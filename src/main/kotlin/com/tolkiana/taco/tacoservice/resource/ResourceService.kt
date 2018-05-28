package com.tolkiana.taco.tacoservice.resource

interface ResourceService {

    fun uploadProduct(name: String, product: Any)

    fun <T> getProduct(name: String, clazz: Class<T>): T
}