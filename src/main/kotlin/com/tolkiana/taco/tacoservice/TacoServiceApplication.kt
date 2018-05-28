package com.tolkiana.taco.tacoservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
open class TacoServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(TacoServiceApplication::class.java, *args)
}
