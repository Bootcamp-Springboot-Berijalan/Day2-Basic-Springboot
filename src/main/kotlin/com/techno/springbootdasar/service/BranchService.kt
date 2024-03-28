package com.techno.springbootdasar.service

import com.techno.springbootdasar.domain.dto.response.ResBranchDataDto
import com.techno.springbootdasar.domain.dto.response.ResBranchDto
import com.techno.springbootdasar.domain.dto.response.ResBranchOutDataDto

interface BranchService {
    fun getBranch(
        search: String, limit: String
    ): ResBranchOutDataDto
}