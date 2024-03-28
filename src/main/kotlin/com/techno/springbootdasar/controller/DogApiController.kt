package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDto
import com.techno.springbootdasar.service.DogApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/dog")
class DogApiController(
    val dogApiService: DogApiService
) {
    @GetMapping("/random-image")
    fun getRandomDogImage(): ResRandomImageDto{
        return dogApiService.getDogImage()
    }
    @GetMapping("/list")
    fun getDogList(): ResDogListDto? {
        return dogApiService.getDogLsit()
    }
}