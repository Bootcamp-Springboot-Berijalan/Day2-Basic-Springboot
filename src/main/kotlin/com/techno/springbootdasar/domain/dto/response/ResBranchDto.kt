package com.techno.springbootdasar.domain.dto.response

data class ResBranchDto(
    val OUT_STAT: String,
    val OUT_MESS: String,
    val OUT_DATA: List<ResBranchOutDataDto>
)
