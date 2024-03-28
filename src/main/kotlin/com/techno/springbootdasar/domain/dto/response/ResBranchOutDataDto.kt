package com.techno.springbootdasar.domain.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ResBranchOutDataDto(
    @JsonProperty("OUT_DATA")
    val OUT_DATA: List<ResBranchDataDto>
)
