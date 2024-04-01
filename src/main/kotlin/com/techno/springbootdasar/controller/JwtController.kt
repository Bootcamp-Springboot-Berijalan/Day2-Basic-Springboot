package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqDecodeJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginJwtDto
import com.techno.springbootdasar.domain.dto.response.*
import com.techno.springbootdasar.service.LoginService
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api")
class JwtController(
    val loginService: LoginService
) {
    @PostMapping("/encode")
    fun encodeJwt(@RequestBody req: ReqEncodeJWTDto): ResponseEntity<ResMessageDto<ResEncodeJWTDto>>{
        val token = JWTGenerator().createJWT(req)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Get Token JWT",
            data = ResEncodeJWTDto(req.id, token)
        ))
    }
    @PostMapping("/decode")
    fun decodeJwt(@RequestBody req: ReqDecodeJWTDto): ResponseEntity<ResMessageDto<ResDecodeJWTDto>>{
        val claim = JWTGenerator().decodeJWT(req.token)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Decode Jwt",
            data = ResDecodeJWTDto(
                claim["id"].toString(),
                claim["role"].toString(),
                claim["email"].toString(),
                claim["password"].toString()
            )
        ))
    }
    @PostMapping("/login")
    fun login(@RequestBody req: ReqLoginDto): ResponseEntity<ResMessageDto<ResLoginDto>>{
        val res = loginService.login(req)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Login",
            data = res
        ))
    }
    @GetMapping("/validate-login")
    fun validate(@RequestHeader token: String): ResponseEntity<ResMessageDto<ResLoginJwtDto>>{
        val claim = JWTGenerator().decodeJWT(token)
        return ResponseEntity.ok(ResMessageDto(
            message = "Success Decode Jwt",
            data = ResLoginJwtDto(
                claim["id"].toString(),
                claim["name"].toString(),
                claim["username"].toString(),
                claim["email"].toString()
            )
        ))
    }
}