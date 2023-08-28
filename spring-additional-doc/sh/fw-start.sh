#!/bin/bash
name=${1};
if [ ! -n "${name}" ] ;then
    echo "please input param [eureka|config|gateway]"
    exit 0;
fi
# 设置进程名关键词
process_keyword="cmp-fw-${name}-1.0.0-SNAPSHOT.jar"
pid=$(ps -ef | grep java | grep "$process_keyword" | grep -v "grep" | awk '{print $2}')
if [ -z "$pid" ] 
 then
    echo "Java start \"$process_keyword\"";
    jvm_opts="";
    case "$name" in
	 eureka)
	      jvm_opts="-Xms1G -Xmx1G";	
	      ;;
	 gateway)
	      jvm_opts="-Xms1G -Xmx1G"; 	
	      ;;
   esac

<<COMMENT	 
    if [ "$name" == "eureka" ] 
      then
	jvm_opts="-Xms1G -Xmx1G";      
    fi
COMMENT

    nohup java $jvm_opts -XX:+UseCodeCacheFlushing -XX:+UseG1GC  -XX:ReservedCodeCacheSize=256m -XX:MaxMetaspaceSize=256m -Dspring.cloud.bootstrap.location=file:./bootstrap-${name}.properties -jar cmp-fw-${name}-1.0.0-SNAPSHOT.jar > $name.out 2>&1 &
 else 
    echo "Java process with pid $pid and keyword \"$process_keyword\" is running"
fi
