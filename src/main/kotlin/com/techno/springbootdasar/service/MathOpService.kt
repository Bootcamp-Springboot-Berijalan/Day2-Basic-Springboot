package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.request.ReqPerhitunganDto
import com.techno.springbootdasar.domain.dto.response.ResHasilDto

interface MathOpService {
    fun add(data: ReqPerhitunganDto): ResHasilDto
    fun subs(data: ReqPerhitunganDto): ResHasilDto
    fun multy(data: ReqPerhitunganDto): ResHasilDto
    fun div(data: ReqPerhitunganDto): ResHasilDto
}