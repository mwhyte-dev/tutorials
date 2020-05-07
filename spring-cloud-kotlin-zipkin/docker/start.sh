#!/usr/bin/env bash

docker run -d -p 8081:9411 --name zipkin openzipkin/zipkin
docker run -d -p 8082:1080 --name employeeService mockserver/mockserver
docker run -d -p 8083:1080 --name payrollService mockserver/mockserver
docker ps -a


sleep 5

# set up some fake endpoints. https://www.mock-server.com/
curl -v -X PUT "http://localhost:8082/mockserver/expectation" -d '{
  "httpRequest" : {
    "method" : "GET",
    "path" : "/employeeService"
  },
  "httpResponse" : {
    "headers": { "content-type": ["application/json"] },
    "body" : "{\"id\": 1, \"employeeName\": \"Joe Bloggs\", \"employeeSalary\": 100000, \"employeeAge\": 35, \"profileImage\": \"some picture\"}",
    "statusCode": 200,
    "delay": {
        "timeUnit": "SECONDS",
        "value": 3
    }
  }}'

curl -v -X PUT "http://localhost:8083/mockserver/expectation" -d '{
  "httpRequest" : {
    "method" : "GET",
    "path" : "/payrollService"
  },
  "httpResponse" : {
    "headers": { "content-type": ["application/json"] },
    "body" : "1",
    "statusCode": 200,
    "delay": {
        "timeUnit": "SECONDS",
        "value": 3
    }
  }}'