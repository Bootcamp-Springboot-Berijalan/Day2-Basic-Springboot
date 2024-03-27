package com.techno.springbootdasar.domain.dto.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ReqInsertDto(
    @field:NotBlank(message = "field name cannot be blank")
    @field:NotEmpty(message = "field name cannot be empty")
    @field:NotNull(message = "field name cannot be null")
    val name: String,

    @field:Size(min = 3, max = 10, message = "field merk must have 3<count<10 char")
    val merk: String
)
