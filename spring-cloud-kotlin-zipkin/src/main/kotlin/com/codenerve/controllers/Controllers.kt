package com.codenerve.controllers

import com.codenerve.services.EmployeeService
import com.codenerve.services.PayrollService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controllers @Autowired constructor(private val employeeService: EmployeeService,
                                         private val payrollService: PayrollService
) {

    @GetMapping("/")
    fun home() = "hello world"


    @GetMapping("/tax")
    fun getTaxByEmployeeId(@RequestParam(value = "name") name: String): Double {

        val employee = employeeService.getEmployeeByName(name)
        val taxCode = payrollService.getTaxCodeByEmployeeId(employee.id)

        return calculateMonthlyTax(employee.employeeSalary, taxCode)
    }

    fun calculateMonthlyTax(salary: Int, taxCode: Int): Double {
        return when (taxCode) {
            1 -> (salary / 100) * 10.0
            2 -> (salary / 100) * 20.0
            3 -> (salary / 100) * 40.0
            else -> {
                throw Exception("Could not calculate tax")
            }
        }
    }
}