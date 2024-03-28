package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.response.ResBranchDto
import com.techno.springbootdasar.domain.dto.response.ResBranchOutDataDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(value = "Branch", url = "https://apidev.acc.co.id/restv2/accgrape/getdata")
interface BranchClient {
    @PostMapping("/getbranch")
    fun getBranches(
        @RequestHeader("APIKey") apiKey: String = "1234567890",
        @RequestHeader("X-Content-Type-Options") xContentTypeOptions: String = "nosniff",
        @RequestHeader("X-XSS-Protection") xXssProtection: String = "1; mode=block",
        @RequestHeader("Strict-Transport-Security") strictTransportSecurity: String = "max-age=31536000; includeSubDomains; preload",
        @RequestHeader("X-Frame-Options") xFrameOption: String = "SAMEORIGIN",
        @RequestBody req: Map<String, Map<String, String>>
    ): ResBranchOutDataDto
}