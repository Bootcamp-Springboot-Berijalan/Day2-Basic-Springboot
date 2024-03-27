package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto

interface MotorManagerService {
    fun insertManager(req: ReqInsertDto): ResMessageDto<String>
}