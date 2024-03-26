package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto
import com.techno.springbootdasar.service.MathOpService
import org.springframework.stereotype.Service

@Service
class MathOpServiceImpl:MathOpService {
    override fun add(data: ReqPerhitunganDto): ResHasilDto {
        val res = ResHasilDto(
            result = data.num1 + data.num2
        )
        return res
    }

    override fun subs(data: ReqPerhitunganDto): ResHasilDto {
        val res = ResHasilDto(
            result = data.num1 - data.num2
        )
        return res
    }

    override fun multy(data: ReqPerhitunganDto): ResHasilDto {
        val res = ResHasilDto(
            result = data.num1 * data.num2
        )
        return res
    }

    override fun div(data: ReqPerhitunganDto): ResHasilDto {
        val res = ResHasilDto(
            result = data.num1 / data.num2
        )
        return res
    }
}