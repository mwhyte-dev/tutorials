package com.codenerve.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class EmployeeService @Autowired constructor(
    private val restTemplate: RestTemplate,
    @Value("\${employee.service.url}") private val url: String
) {

    fun getEmployeeByName(id: String) : Employee {
        val responseEntity = restTemplate.getForEntity(url, Employee::class.java)
        return responseEntity.body!!
    }

    data class Employee(val id: Long,
                        val employeeName: String,
                        val employeeSalary: Int,
                        val employeeAge: Int,
                        val profileImage: String)
}