#!/bin/sh
cd /app/icf-business/
git pull

name=${1};
profile="prod";
if [ ! -n "${name}" ] || [ ! -n "${profile}" ];
  then
    echo "please input run param [base|um|icf|solution|client|scheduler]";
    echo "run sample: ./build.sh base";
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
  scheduler)
      ;;
  *)
    echo "please input 1st param [base|um|icf|solution|client|scheduler]";
          exit 0;
esac


cd /app/icf-business/cmp-business-icf/cmp-biz-${name}
mvn clean
mvn install -Dmaven.test.skip=true

echo "stop service biz-${name}";
cd /app/prod-biz-server
sh biz-stop.sh ${name}

cp /app/icf-business/cmp-business-icf/cmp-biz-${name}/target/cmp-biz-${name}-1.0.0-SNAPSHOT.jar /app/prod-biz-server/cmp-biz-${name}-1.0.0-SNAPSHOT.jar -rf
echo "start service biz-${name}"
sh biz-start.sh ${name}

