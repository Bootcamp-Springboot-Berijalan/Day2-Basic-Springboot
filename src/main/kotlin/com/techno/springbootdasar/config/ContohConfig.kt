package com.techno.springbootdasar.config

import com.techno.springbootdasar.service.LogicService
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class ContohConfig(
    private val logicService: LogicService
) {
    @Bean
    fun printName(){
        println("Name: Maulana Daffa A")
    }
    @Bean
    fun getOddOrEven(){
        val result = logicService.oddOrEven(5)
        println("Number is $result")
    }
}