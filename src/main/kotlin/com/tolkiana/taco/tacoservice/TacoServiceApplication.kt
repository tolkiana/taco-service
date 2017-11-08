package com.tolkiana.taco.tacoservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TacoServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(TacoServiceApplication::class.java, *args)
}
