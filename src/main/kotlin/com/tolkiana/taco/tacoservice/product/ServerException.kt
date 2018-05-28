package com.tolkiana.taco.tacoservice.product

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "There was a server error")
class ServerException(message: String) : RuntimeException(message)