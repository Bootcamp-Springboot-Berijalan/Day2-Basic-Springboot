package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import java.util.*

interface ProfileService {
    fun create(req: ReqProfileDto): ResMessageDto<String>
    fun readAll(): ResMessageDto<List<ResProfileDto>>
    fun readById(id: Int): ResMessageDto<ResProfileDto>
    fun update(id: Int, req: ReqProfileDto): ResMessageDto<String>
    fun delete(id: Int): ResMessageDto<String>
}