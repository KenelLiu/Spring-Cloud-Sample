1.www.itldc.com
2.检查分配ip是否正确
    ifconfig
3.Update Ubuntu
    sudo apt update && sudo apt upgrade
    echo 'fs.file-max = 65535' | sudo tee -a /etc/sysctl.conf
    sudo sysctl -p
4.Check the Current TCP Congestion Control Algorithm
    sudo sysctl net.ipv4.tcp_congestion_control
    After executing the specified command,may be displayed  
      net.ipv4.tcp_congestion_control = cubic
5.Enable BBR  
    sudo echo 'net.core.default_qdisc=fq' | tee -a /etc/sysctl.conf
    sudo echo 'net.ipv4.tcp_congestion_control=bbr' |  tee -a /etc/sysctl.conf
    sudo sysctl -p
    验证是否已启用 sudo sysctl net.ipv4.tcp_congestion_control      
    查看:lsmod | grep bbr
6.修改打开文件数量
sudo tee -a /etc/security/limits.conf << EOF
*	hard	nofile	65535
*	soft	nofile	65535
root	hard	nofile	65535
root	soft	nofile	65535
EOF  

sudo sed -i '/DefaultLimitNOFILE/c DefaultLimitNOFILE=65535' /etc/systemd/*.conf
sudo systemctl daemon-reexec

7. 查看域名解释服务
 cat /etc/resolv.conf 
nameserver 1.1.1.1
nameserver 8.8.8.8
查看软件
  dpkg -l “dnsmasq”
  dpkg -l “net-tools”
  dpkg -l “rsyslog”
若没有安装,进行安装
apt-get install dnsmasq
apt-get install net-tools
apt-get install rsyslog

8.检查网络
  ping baidu.com
  ping google.com
  若不通,检查是否因为iptables 阻止了

9.安装shadowsocks
  apt-get install shadowsocks-libev
  vi /etc/shadowsocks-libev/config.json  修改配置
  service shadowsocks-libev restart

10.https://github.com/shadowsocks/ 下载windows版本
    设置:
	系统代理 PAC模式
	PAC模式 从geosite更新
	配置1080 端口代理
         
 
11.在google应用商店安装SwitchyOmega
   点chrome 浏览页 extensions 开启SwitchyOmega
   点SwitchyOmega option
       a.创建 Proxy Profile 【127.0.0.1，1080】对应【windows安装客户端 1080端口】，命名myserver
       b.创建Switch Profile,命名myswitch,
         选中AutoProxy
          https://raw.githubusercontent.com/gfwlist/gfwlist/master/gfwlist.txt
         下载好后
         Rule list rules 对应刚才myserver
   应用即可