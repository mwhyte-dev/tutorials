#!/usr/bin/env bash

docker container stop zipkin
docker container rm zipkin
docker container stop employeeService
docker container rm employeeService
docker container stop payrollService
docker container rm payrollService
docker ps -a