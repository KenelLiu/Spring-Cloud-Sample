#!/bin/bash
name=${1};
profile=${2};
if [ ! -n "${name}" ] || [ ! -n "${profile}" ];
  then
    echo "please input run param [eureka|config|gateway] [prod|test]";
    echo "run sample: ./fw-start.sh eureka prod";
    exit 0;
fi
## 设置jvm_opt
jvm_opts="";
case "$name" in
  eureka)
      jvm_opts="-Xms1G -Xmx1G -XX:+UseCodeCacheFlushing -XX:+UseG1GC  -XX:ReservedCodeCacheSize=256m -XX:MaxMetaspaceSize=256m";
	      ;;
	config)
      jvm_opts="";
	     ;;
  gateway)
      jvm_opts="-Xms1G -Xmx1G -XX:+UseCodeCacheFlushing -XX:+UseG1GC  -XX:ReservedCodeCacheSize=256m -XX:MaxMetaspaceSize=256m";
	      ;;
  *)
    echo "please input 1st param [eureka|config|gateway]"
	  exit 0;
esac
## 设置profile ##
case "$profile" in
  prod)
      profile="";
	      ;;
	test)
      profile="test-";
      jvm_opts="";
	     ;;
  *)
    echo "please input 2nd param [prod|test]";
	  exit 0;
esac
## 设置进程名关键词 ##
process_keyword="file:./${profile}bootstrap-${name}.properties -jar ${profile}cmp-fw-${name}-1.0.0-SNAPSHOT.jar";
pid=$(ps -ef | grep java | grep "$process_keyword" | grep -v "grep" | awk '{print $2}')
if [ -z "$pid" ] 
 then
    echo "Java start \"$process_keyword\"";
    nohup java $jvm_opts -Dspring.cloud.bootstrap.location=file:./${profile}bootstrap-${name}.properties -jar ${profile}cmp-fw-${name}-1.0.0-SNAPSHOT.jar > ${profile}$name.out 2>&1 &
 else 
    echo "Java process with pid $pid and keyword \"$process_keyword\" is running";
fi