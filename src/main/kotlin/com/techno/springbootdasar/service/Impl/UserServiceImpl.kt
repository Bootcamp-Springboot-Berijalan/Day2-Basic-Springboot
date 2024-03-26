package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResUserDto
import com.techno.springbootdasar.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UserServiceImpl:UserService {
    override fun getUserData(): ResUserDto {
        val response = ResUserDto(
            firstName = "Maulana",
            lastName = "Daffa"
        )
        return response
    }
}