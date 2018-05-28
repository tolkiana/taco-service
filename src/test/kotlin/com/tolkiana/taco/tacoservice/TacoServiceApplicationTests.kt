package com.tolkiana.taco.tacoservice

import com.tolkiana.taco.tacoservice.resource.ResourceService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class TacoServiceApplicationTests {

    @MockBean
    lateinit var resourceService: ResourceService

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Before
    fun setUp() {
        `when`(resourceService.getProducts(Matchers.anyString())).thenReturn(emptyList())
    }

    @Test
    fun contextLoads() {
        //When
        val application = applicationContext.getBean(TacoServiceApplication::class.java)

        //Then
        assertThat(application).isNotNull()
    }
}
