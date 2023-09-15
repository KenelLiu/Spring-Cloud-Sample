#!/bin/bash

eureka_server_port=11004;
config_server_port=11002;

function  start()
{
    curServer=$1;
    nextServer=$2;
    eval current_server_port="\$${curServer}_server_port";

    num=1;
    while [ $num -le 10 ]
     do
       bFind="false";
       listenServer=$(sudo netstat -talp|grep "LISTEN"|grep "java" | awk '{print $4}')
       port_array=(${listenServer// / })
       ##查找eureka服务是否已经启动##
       for port in ${port_array[@]};
        do
         result=$(echo ${port}|grep "${current_server_port}")
         if [[ "$result" != "" ]]
          then
            bFind="true";
            break;
         fi
        done
      if [ "${bFind}" == "true" ];
       then
         sh fw-start.sh ${nextServer}
         break;
       else
         sleep 2
      fi
      num=$(( $num + 1 ))
    done	
}

##启动eureka##
sh fw-start.sh eureka;
sleep 3;
##eureka 启动后,启动config
start "eureka" "config";
sleep 3;
##config 启动后,启动gateway
start "config" "gateway";
