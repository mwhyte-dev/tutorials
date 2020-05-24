package com.codenerve.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class Controllers {

    @GetMapping("/")
    fun home() = "index"
}