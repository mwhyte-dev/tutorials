#!/usr/bin/env bash

# spring boot app
open http://localhost:8080/tax?name=michael

# zipkin
open http://localhost:8081

# mock services
open http://localhost:8082/employeeService
open http://localhost:8083/payrollService