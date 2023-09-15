#!/bin/bash

fw_name_array=("gateway","config","eureka");
for name in ${fw_name_array[@]};
do
  sh fw-stop.sh ${name}
done	

