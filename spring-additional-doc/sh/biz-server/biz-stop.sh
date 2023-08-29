#!/bin/bash
name=${1};
profile=${2};
if [ ! -n "${name}" ] || [ ! -n "${profile}" ];
  then
    echo "please input run param [base|um|icf|solution|client] [prod|test]";
    echo "run sample: ./biz-stop.sh base prod";
    exit 0;
fi
##判断$name输入是否正确##
case "$name" in
  base)
	    ;;
	um)
      ;;
  icf)
      ;;
  solution)
      ;;
  client)
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
process_keyword="file:./${profile}bootstrap-biz.properties -jar ${profile}cmp-biz-${name}-1.0.0-SNAPSHOT.jar";
pid=$(ps -ef | grep java | grep "$process_keyword" | grep -v "grep" | awk '{print $2}')
if [ -z "$pid" ]
 then
    echo "Java  \"$process_keyword\" already stoped";
 else
    kill -9 $pid;
    echo "Java process with pid $pid and keyword \"$process_keyword\" is stopping";
fi