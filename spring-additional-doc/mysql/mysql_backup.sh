#!/bin/bash

#备份保存路径
backup_dir=/data/backup
#日期
dd=`date +%Y%m%d%H`
#备份工具
tool=mysqldump
#用户名,密码
userfile=$backup_dir/user.cnf
#备份的数据库

database_name_array=("oceanv5" "530chart")

for database_name in ${database_name_array[@]};
do
    #echo $database_name
    $tool --defaults-extra-file=$userfile  $database_name > $backup_dir/mysqlbackup/$database_name-$dd.sql
    cd $backup_dir/mysqlbackup
    tar -czf $database_name-$dd.sql.tar.gz $database_name-$dd.sql
    rm $backup_dir/mysqlbackup/$database_name-$dd.sql
done

