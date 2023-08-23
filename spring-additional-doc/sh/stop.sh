#!/bin/bash
# 设置进程名关键词
process_keyword="file:./application.yml -jar cmp-biz-icf-assess-1.0.jar"
# 获取与关键词匹配的 Java 进程 ID
pid=$(ps -ef | grep java | grep "$process_keyword" | grep -v "grep" | awk '{print $2}')

# 判断进程 ID 是否存在
if [ -z "$pid" ]
 then
    echo "Java process with keyword \"$process_keyword\" is not running"
 else
    # 杀死进程
    kill -9 $pid
    echo "Java process with pid $pid and keyword \"$process_keyword\" has been stopped"
fi

