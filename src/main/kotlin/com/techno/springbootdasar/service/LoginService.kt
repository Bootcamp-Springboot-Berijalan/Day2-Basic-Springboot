package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqLoginDto
import com.techno.springbootdasar.domain.dto.response.ResLoginDto

interface LoginService {
    fun login(req: ReqLoginDto): ResLoginDto
}