package com.codenerve.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class PayrollService @Autowired constructor(
    private val restTemplate: RestTemplate,
    @Value("\${payroll.service.url}") private val url: String
) {

    fun getTaxCodeByEmployeeId(id: Long): Int {
        val responseEntity = restTemplate.getForEntity(url, Int::class.java)
        return responseEntity.body!!
    }
}