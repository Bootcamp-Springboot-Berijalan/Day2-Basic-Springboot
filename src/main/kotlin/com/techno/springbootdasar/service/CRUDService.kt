package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.response.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import java.util.UUID

interface CRUDService {
    fun insert(req: ReqInsertDto):ResMessageDto<String>
    fun update(uuid: UUID, req: ReqInsertDto): ResMessageDto<String>
    fun detail(uuid: UUID): ResMessageDto<ResGetMotorDto>
    fun list(): ResMessageDto<List<ResGetMotorDto>>
    fun delete(uuid: UUID): ResMessageDto<String>
}