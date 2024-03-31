package com.techno.springbootdasar.rest

import com.techno.springbootdasar.domain.dto.response.ResAvatarDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(value = "Avatar", url = "https://api.dicebear.com")
interface AvatarClient {
    @GetMapping("/8.x/pixel-art/svg", produces = ["images/svg+xml"])
    fun getAvatar(@RequestParam seed: String): ResponseEntity<ByteArray>
}