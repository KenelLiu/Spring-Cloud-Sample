#!/bin/bash
name=${1};
profile="prod";
if [ ! -n "${name}" ] || [ ! -n "${profile}" ];
  then
    echo "please input run param [base|um|icf|solution|client]";
    echo "run sample: ./biz-start.sh base";
    exit 0;
fi
## 设置jvm_opt 暂时未设置
jvm_opts="";
case "$name" in
  base)
      jvm_opts="";
	    ;;
	um)
      jvm_opts="";
      ;;
  icf)
      jvm_opts="";
      ;;
  solution)
      jvm_opts="";
      ;;
  client)
      jvm_opts="";
      ;;
  *)
    echo "please input 1st param [base|um|icf|solution|client]";
	  exit 0;
esac
## 设置profile ##
case "$profile" in
  prod)
      profile="";
	      ;;
	test)
      profile="test-";
	     ;;
  *)
    echo "please input 2nd param [prod|test]";
	  exit 0;
esac
# 设置进程名关键词
process_keyword="file:./${profile}bootstrap-biz-${name}.properties -jar ${profile}cmp-biz-${name}-1.0.0-SNAPSHOT.jar";
pid=$(ps -ef | grep java | grep "$process_keyword" | grep -v "grep" | awk '{print $2}')
if [ -z "$pid" ]
 then
    echo "Java start \"$process_keyword\"";
    nohup java -Dspring.cloud.bootstrap.location=file:./${profile}bootstrap-biz-${name}.properties -jar ${profile}cmp-biz-${name}-1.0.0-SNAPSHOT.jar > ${profile}biz-${name}.out 2>&1 &
 else 
    echo "Java process with pid $pid and keyword \"$process_keyword\" is running";
fi
