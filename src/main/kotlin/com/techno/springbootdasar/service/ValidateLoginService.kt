package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResLoginJwtDto

interface ValidateLoginService {
    fun validateLogin(token: String): ResLoginJwtDto
}