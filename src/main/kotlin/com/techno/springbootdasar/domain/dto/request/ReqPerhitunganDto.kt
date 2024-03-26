package com.techno.springbootdasar.domain.dto.request

import com.fasterxml.jackson.annotation.JsonProperty

data class ReqPerhitunganDto(
    @JsonProperty("num1")
    val num1: Int,
    @JsonProperty("num2")
    val num2: Int
)
