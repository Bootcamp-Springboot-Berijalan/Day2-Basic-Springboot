package com.techno.springbootdasar.domain.dto.response

data class ResDogListDto(
    val message: Map<String, List<String>>,
    val status: String
)
