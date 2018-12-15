#!/bin/bash
docker run -d -t --privileged=true -p 8081:8080 khteh/tomcat:restapi-1.0
