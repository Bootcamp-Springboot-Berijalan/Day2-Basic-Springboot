package com.techno.springbootdasar.service

import org.springframework.stereotype.Service

@Service
class LogicService {
    fun oddOrEven (number: Int): String{
        if(number % 2 == 0){
            return "Even"
        }else{
            return "Odd"
        }
    }
}