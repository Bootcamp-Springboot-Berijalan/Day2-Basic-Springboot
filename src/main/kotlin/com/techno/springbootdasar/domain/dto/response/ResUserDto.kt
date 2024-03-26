package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResUserDto(
//    @JsonProperty("firstname")
    val firstName: String,
    val lastName: String
)
