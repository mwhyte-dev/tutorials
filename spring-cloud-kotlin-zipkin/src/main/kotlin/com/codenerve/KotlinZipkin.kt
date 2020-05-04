package com.codenerve

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinZipkin

fun main(args: Array<String>) {
    runApplication<KotlinZipkin>(*args)
}