package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqNumberDto
import com.techno.springbootdasar.domain.dto.request.ReqUserDto
import com.techno.springbootdasar.domain.dto.response.ResUserDto
import com.techno.springbootdasar.service.LogicService
import com.techno.springbootdasar.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class TestController (
    @Value("\${name.firstName}") private val firstName: String,
    @Value("\${name.lastName}") private val lastName: String? = null,
    private val logicService: LogicService,
    val userDataService: UserService
) {
    @GetMapping("/test")
    fun testGetMapping(): ResponseEntity<LinkedHashMap<String, String>> {
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_nam"] = lastName!!

        return ResponseEntity.ok().body(response)
    }
    @GetMapping("/user")
    fun getAge(@RequestParam("age") age: String): ResponseEntity<Any>{
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_nam"] = lastName!!
        response["age"] = age

        return ResponseEntity.ok().body(response)
    }
    @GetMapping("/user/{role}")
    fun getRole(@PathVariable("role") role : String): ResponseEntity<Any>{
        val response: LinkedHashMap<String, String> = LinkedHashMap()
        response["first_name"] = firstName
        response["last_nam"] = lastName!!
        response["role"] = role

        return ResponseEntity.ok().body(response)
    }
    @PostMapping("/oddOrEven")
    fun getOddOrEven(@RequestBody request: ReqNumberDto): ResponseEntity<Any>{
        val response = LinkedHashMap<String, String>()
        response["result"] = logicService.oddOrEven(request.number)
        return ResponseEntity.ok().body(response)
    }

    @GetMapping("/testwnh")
    fun testwnh(): ResponseEntity<ResUserDto>{
        val response = ResUserDto(
            firstName = "Maulana",
            lastName = "Daffa"
        )
        return ResponseEntity.ok(response)
    }
    @PostMapping("/userData")
    fun newUser(@RequestBody request: ReqUserDto): ResponseEntity<ResUserDto>{
        val response = userDataService.getUserData()
        return ResponseEntity.ok(response)
    }
}