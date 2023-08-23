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

# 重启 Java 应用程序
nohup java -Xms2g -Xmx2g -XX:+UseCodeCacheFlushing -XX:+UseG1GC -XX:ReservedCodeCacheSize=512m  -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/ICFApi/error.hprof -Dspring.config.location=file:./application.yml -jar cmp-biz-icf-assess-1.0.jar &
echo "Java start....."
# nohup java -jar cmp-biz-$name-1.0.0-SNAPSHOT.jar > $name.out 2>&1 &
# -XX:MetaspaceSize=128m：元空间默认大小
# -XX:MaxMetaspaceSize=256m：元空间最大大小
# -XX:InitialHeapSize：指定 JVM 最初的堆内存大小。
# -XX:MaxHeapSize：指定 JVM 最大允许的堆内存大小。
# -Xms2048m：堆初始值
# -Xmx2048m：堆最大值
# -Xmn256m：新生代大小
# -Xss256k：栈最大深度大小
# -XX:SurvivorRatio=8：新生代分区比例 8:2
# -XX:SurvivorSpaceRatio=50
# -XX:+UseConcMarkSweepGC：指定使用的垃圾收集器，这里使用CMS收集器
# -XX:+PrintGCDetails：打印详细的GC日志
# -XX:+UseCodeCacheFlushing
# -XX:+UseParallelGC 
# -XX:-UseAdaptiveSizePolicy  
# -XX:ReservedCodeCacheSize=512m
#-XX:PermSize/-XX:MaxPermSize
#-XX:MetaspaceSize/-XX:MaxMetaspaceSize
# http://180.167.232.10:38000/
#echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope 在linux使用jdk jmap 需要设置ptrace_scope=0

#JVM格式规范
# https://docs.oracle.com/javase/specs/index.html
#诊断工具：
#　　http://docs.oracle.com/javase/8/docs/technotes/guides/troubleshoot/
#   https://docs.oracle.com/javase/7/docs/technotes/tools/share/jstat.html
#调优参数
#　　http://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/
#jvm
#    http://docs.oracle.com/javase/8/docs/technotes/guides/vm/index.html
#    http://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
#原理:
#    https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/G1GettingStarted/index.html
#统计:
#jstat -gcutil <pid> 5000
#jstat -gcutil 命令是用来监控 Java 虚拟机的垃圾回收统计信息。具体参数的含义如下：
#S0: Survivor 0 区已使用内存比例
#S1: Survivor 1 区已使用内存比例
#E: Eden 区已使用内存比例
#O: Old 区已使用内存比例
#M: 元数据区已使用内存比例
#CCS: 压缩类空间已使用内存比例
#YGC: 从应用程序启动到采样时发生 Young GC 的次数
#YGCT: 从应用程序启动到采样时 Young GC 所用的时间（单位秒）
#FGC: 从应用程序启动到采样时发生 Full GC 的次数
#FGCT: 从应用程序启动到采样时 Full GC 所用的时间（单位秒）
#GCT: 从应用程序启动到采样时垃圾回收所用的总时间（单位秒）
#其中，M 表示元数据区已使用内存比例，CCS 表示压缩类空间已使用内存比例。元数据区主要用来存储类的元数据信息，如类名、方法名、字段名等。压缩类空间则是一种针对类元数据的内存压缩技术，可以有效地降低 JVM 的内存占用

#jmap -dump:format=b,file=hprof 进程PID

#jstat -gcmetacapacity <pid>
#MCMN（Metaspace Capacity Min）：表示 Metaspace 区域的最小容量。如果 Metaspace 区域的使用量低于此值，JVM 不会减少 Metaspace 区域的容量。
#MCMX（Metaspace Capacity Max）：表示 Metaspace 区域的最大容量。如果 Metaspace 区域的使用量超过此值，JVM 会自动增加 Metaspace 区域的容量。
#MC（Metacapacity）：表示 Metaspace 区域的当前容量。如果 Metaspace 区域的使用量接近此值，JVM 可能会增加 Metaspace 区域的容量。
#CCSMN（Compressed Class Space Minimum）：表示压缩类空间的最小容量。
#CCSMX（Compressed Class Space Maximum）：表示压缩类空间的最大容量。
#CCSC（Compressed Class Space Current）：表示压缩类空间的当前容量。如果压缩类空间的使用量接近此值，JVM 可能会增加压缩类空间的容量。
#需要注意的是，Metaspace 区域和压缩类空间是虚拟机的一部分，用于存储类和元数据信息。这些区域的容量和使用情况直接影响 JVM 的性能和稳定性。
