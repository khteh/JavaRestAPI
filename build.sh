#!/bin/bash
docker build -t khteh/restapi:latest .
docker push khteh/restapi:latest
#mvn clean package install
