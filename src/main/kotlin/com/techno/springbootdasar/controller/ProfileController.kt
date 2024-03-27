package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import com.techno.springbootdasar.service.ProfileService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tugas/profile")
class ProfileController(
    val profileService: ProfileService
) {
    @PostMapping("/create")
    fun insert(@Valid @RequestBody req: ReqProfileDto): ResponseEntity<ResMessageDto<String>>{
        val res = profileService.create(req)
        return ResponseEntity.ok(res)
    }
    @GetMapping("/profiles")
    fun getAllProfiles(): ResponseEntity<ResMessageDto<List<ResProfileDto>>>{
        val res = profileService.readAll()
        return ResponseEntity.ok(res)
    }
    @GetMapping("/")
    fun getProfileById(id: Int): ResponseEntity<ResMessageDto<ResProfileDto>>{
        val res = profileService.readById(id)
        return ResponseEntity.ok(res)
    }
    @PutMapping("/update")
    fun update(
        @Valid
        @RequestBody req: ReqProfileDto,
        @RequestParam id: Int
    ): ResponseEntity<ResMessageDto<String>>{
        val res = profileService.update(id, req)
        return ResponseEntity.ok(res)
    }
    @DeleteMapping("/delete")
    fun delete(@RequestParam id: Int): ResponseEntity<ResMessageDto<String>>{
        val res = profileService.delete(id)
        return ResponseEntity.ok(res)
    }
}