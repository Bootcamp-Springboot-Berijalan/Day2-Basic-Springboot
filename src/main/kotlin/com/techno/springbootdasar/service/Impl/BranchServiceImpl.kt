package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.response.ResBranchDataDto
import com.techno.springbootdasar.domain.dto.response.ResBranchDto
import com.techno.springbootdasar.domain.dto.response.ResBranchOutDataDto
import com.techno.springbootdasar.rest.BranchClient
import com.techno.springbootdasar.service.BranchService
import org.springframework.stereotype.Service

@Service
class BranchServiceImpl(
    private val branchClient: BranchClient
): BranchService {
    override fun getBranch(search: String, limit: String): ResBranchOutDataDto {
        val reqArea = mapOf("P_SEARCH" to search, "P_LIMIT" to limit)
        val requestBranch: Map<String, Map<String, String>> = mapOf("doGetBranch" to reqArea)
        val branches = branchClient.getBranches(req = requestBranch)
        return branches
    }
}