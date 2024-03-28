package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResDogListDto
import com.techno.springbootdasar.domain.dto.response.ResRandomImageDto
import com.techno.springbootdasar.rest.DogApiClient
import com.techno.springbootdasar.service.DogApiService
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class DogApiServiceImpl(
    private val dogApiClient: DogApiClient,
    val restTemplate: RestTemplate = RestTemplateBuilder().build()
): DogApiService {
    override fun getDogImage(): ResRandomImageDto {
        return dogApiClient.getRandomImage()
    }

    override fun getDogLsit(): ResDogListDto? {
        val res: ResDogListDto? = restTemplate.getForObject(
            "https://dog.ceo/api/breeds/list/all",
            ResDogListDto::class.java
        )
        return res?.let { ResDogListDto(it.message, it.status) }
    }
}