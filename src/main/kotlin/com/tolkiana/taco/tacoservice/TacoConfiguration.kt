package com.tolkiana.taco.tacoservice

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import feign.jackson.JacksonDecoder
import feign.jackson.JacksonEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TacoConfiguration {

    @Bean
    fun objectMapper(): ObjectMapper {
        return jacksonObjectMapper()
    }

    @Bean
    fun jacksonEncoder(objectMapper: ObjectMapper): JacksonEncoder {
        return JacksonEncoder(objectMapper)
    }

    @Bean
    fun jacksonDecoder(objectMapper: ObjectMapper): JacksonDecoder {
        return JacksonDecoder(objectMapper)
    }
}