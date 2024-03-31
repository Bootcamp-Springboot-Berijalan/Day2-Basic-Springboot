package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.response.ResBranchOutDataDto
import com.techno.springbootdasar.service.BranchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/branches")
class BranchController(val branchService: BranchService) {
    @GetMapping
    fun postACCApiClient(
        @RequestParam search: String,
        @RequestParam limit: String
    ): ResBranchOutDataDto {
        return branchService.getBranch(search, limit)
    }
}
