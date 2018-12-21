#!/bin/bash
#docker run -d -t --privileged=true -p 8081:8080 khteh/tomcat:restapi-1.0
#docker run -e SPRING_PROFILES_ACTIVE=dev -d -t -p 8081:8080 khteh/tomcat:restapi-1.0
docker run -e SPRING_PROFILES_ACTIVE=prod -e SPRING_CONFIG_LOCATION="/etc/application/config/application.yml" -e SPRING_CONFIG_NAME="application.yml" -d -t -p 8081:8080 khteh/tomcat:restapi-1.0
