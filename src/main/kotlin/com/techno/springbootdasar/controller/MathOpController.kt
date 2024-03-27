package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto
import com.techno.springbootdasar.service.MathOpService
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mathop")
class MathOpController(
    val mathOpService: MathOpService
) {
    @PostMapping("/addition")
    fun getAdd(@RequestBody req: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val res = mathOpService.add(req)
        return ResponseEntity.ok(res)
    }
    @PostMapping("/subtraction")
    fun getSubs(@RequestBody req: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val res = mathOpService.subs(req)
        return ResponseEntity.ok(res)
    }
    @PostMapping("/multiplication")
    fun getMulty(@RequestBody req: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val res = mathOpService.multy(req)
        return ResponseEntity.ok(res)
    }
    @PostMapping("/division")
    fun getDiv(@RequestBody req: ReqPerhitunganDto): ResponseEntity<ResHasilDto>{
        val res = mathOpService.div(req)
        return ResponseEntity.ok(res)
    }
}