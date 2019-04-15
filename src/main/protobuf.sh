#!/bin/bash
/opt/protobuf-3.6.1/bin/protoc -I java/com --java_out=java/com --proto_path=./resources courses.proto
