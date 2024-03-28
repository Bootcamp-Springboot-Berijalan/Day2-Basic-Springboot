package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDto

interface DogApiService {
    fun getDogImage(): ResRandomImageDto
    fun getDogLsit(): ResDogListDto?
}