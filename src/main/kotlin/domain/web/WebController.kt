package com.example.demo.domain.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {

    @GetMapping("/hello")
    fun sayHello(): String {
        return "Привет от Kotlin + Spring Boot!"
    }
}
