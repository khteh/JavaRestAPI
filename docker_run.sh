#!/bin/bash
docker run -d -t --privileged=true -p 8081:8080 khteh/tomcat:tomcat-restapi
