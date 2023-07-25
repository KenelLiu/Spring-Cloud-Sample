1.启动config-server-jdbc
2.启动config-client-jdbc
3.查看配置：
  http://localhost:8010/api/configs
4.数据库修改配置值
5.未启用amqp时 curl -X POST  http://localhost:8010/actuator/refresh 刷新配置 
  启用amqp时 curl -X POST  http://localhost:8888/actuator/busrefresh 刷新配置
  重新查看配置: http://localhost:8010/api/configs

参考资料
https://sahana-bhat.medium.com/spring-cloud-config-server-with-jdbc-backend-bdb03f2a37d0