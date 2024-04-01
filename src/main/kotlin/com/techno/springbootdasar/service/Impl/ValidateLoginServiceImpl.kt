package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResLoginJwtDto
import com.techno.springbootdasar.service.ValidateLoginService
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.stereotype.Service

@Service
class ValidateLoginServiceImpl(): ValidateLoginService {
    override fun validateLogin(token: String): ResLoginJwtDto {
        val claim = JWTGenerator().decodeJWT(token)
        return ResLoginJwtDto(
            claim["id"].toString(),
            claim["name"].toString(),
            claim["username"].toString(),
            claim["email"].toString()
        )
    }
}