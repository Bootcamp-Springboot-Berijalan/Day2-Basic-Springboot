package com.techno.springbootdasar.domain.dto.response

import java.util.UUID

data class ResGetMotorDto(
    val id: UUID?,
    val name: String?,
    val merk: String?
)
