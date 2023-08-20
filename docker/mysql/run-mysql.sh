#!/bin/bash
# docker build . -t mysql 
docker run --name mymysql \
-e MYSQL_ROOT_PASSWORD=example \
-e MYSQL_DATABASE=eazybank \
-e MYSQL_USER=eazybank \
-e MYSQL_PASSWORD=test \
-v /home/ciprian/Dev/mysql2:/var/lib/mysql \
-p 3306:3306 
-d mysql
