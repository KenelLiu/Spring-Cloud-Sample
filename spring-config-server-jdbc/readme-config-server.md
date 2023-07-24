https://sahana-bhat.medium.com/spring-cloud-config-server-with-jdbc-backend-bdb03f2a37d0
1.启动config-server-jdbc
2.启动config-client-jdbc
http://localhost:8010/api/configs

curl -X POST  http://localhost:8010/actuator/refresh
curl -X POST  http://localhost:8888/actuator/busrefresh