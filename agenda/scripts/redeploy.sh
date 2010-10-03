#!/usr/bin/env bash

cd ..
mvn -e clean package tomcat:redeploy \
    -Dmaven.tomcat.server=tomcat-local-users \
    -Dmaven.tomcat.url=http://localhost:8080/manager \
    -Dmaven.tomcat.path=/agenda