package com.spring.gateway;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.factory.AddRequestHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.AddResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.handler.predicate.CookieRoutePredicateFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.regex.Pattern;

@Slf4j
@EnableDiscoveryClient  // 发现服务
@SpringBootApplication
@RestController

public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        log.info("============GatewayApplication 启动完成========");

        // AddRequestHeaderGatewayFilterFactory
        //  AddResponseHeaderGatewayFilterFactory
    }

    @Bean
    public GlobalFilter customFilter() {
        return new CustomGlobalFilter();
    }

    public class CustomGlobalFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            log.info("custom global filter");
            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return 99;
        }
    }

    /**
    @Bean
    public RouteLocator route(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(p->p.path("/get")
                        .filters(f->f.addRequestHeader("hello","word"))
                        .uri("http://httpbin.org/"))
                .route(p->p.host("10.27.89.*")
                        .filters(f->f.circuitBreaker(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback"))
                                )
                        .uri("http://httpbin.org/"))
                .route(p->p.host("*.circuitbreaker.com")
                           .filters(f->f.circuitBreaker(config -> config
                                   .setName("mycmd1")
                                   .setFallbackUri("forward:/fallback")))
                           .uri("http://httpbin.org/")
                        )
                .build();
    }
     //curl --dump-header - --header 'Host:www.circuitbreaker.com' http://10.27.89.249/delay/3
     **/
    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}
