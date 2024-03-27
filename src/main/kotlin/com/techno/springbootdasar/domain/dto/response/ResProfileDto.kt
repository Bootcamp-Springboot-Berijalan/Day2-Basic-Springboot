package com.techno.springbootdasar.domain.dto.response

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class ResProfileDto(
    val id: Int?,
    val name: String?,
    val username: String?,
    val email: String?,
    val password: String?,
)
