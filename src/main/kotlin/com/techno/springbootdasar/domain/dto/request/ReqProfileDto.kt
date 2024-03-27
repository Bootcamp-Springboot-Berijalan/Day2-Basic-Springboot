package com.techno.springbootdasar.domain.dto.request

import jakarta.persistence.UniqueConstraint
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.UniqueElements

data class ReqProfileDto(
    @field:NotEmpty(message = "name cannot be empty")
    @field:NotBlank(message = "name cannot be blank")
    @field:Pattern(regexp = "^[a-zA-Z ]*\$", message = "name cannot contain numeric")
    @field:Size(max = 100, message = "username must be <100 char")
    val name: String,
    @field:NotEmpty(message = "username cannot be empty")
    @field:NotBlank(message = "username cannot be blank")
    @field:Pattern(regexp = "^[^\\s]*\$", message = "username cannot contain spaces")
    @field:Size(max = 32, message = "username must be <32 char")
    val username: String,
    @field:NotEmpty(message = "email cannot be empty")
    @field:NotBlank(message = "email cannot be blank")
    @field:Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\$", message = "email must in the right email format")
    val email: String,
    @field:NotEmpty(message = "password cannot be empty")
    @field:NotBlank(message = "password cannot be blank")
    @field:Size(max = 32, message = "password must be <32 char")
    val password: String,
)
