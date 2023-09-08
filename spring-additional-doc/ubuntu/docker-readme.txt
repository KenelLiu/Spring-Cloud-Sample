##已安装rabbitmq 使用下面端口做springcloud 正式环境配置,下次仅启动容器即可
#sudo docker run -d --hostname prod-rabbit --name prod-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
#sudo docker run -d --hostname test-rabbit --name test-rabbit -p 15872:15672 -p 5872:5672 rabbitmq:3-management
## 查看容器列表
sudo docker ps -a 
## 启动容器
sudo docker start <name>
sudo docker start <containerId> 
