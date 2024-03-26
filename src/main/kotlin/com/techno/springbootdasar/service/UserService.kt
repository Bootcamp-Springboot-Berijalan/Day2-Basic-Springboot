package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResUserDto

interface UserService {
    fun getUserData(): ResUserDto
}