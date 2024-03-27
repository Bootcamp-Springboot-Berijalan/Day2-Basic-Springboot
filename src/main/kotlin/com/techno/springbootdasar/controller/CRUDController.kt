package com.techno.springbootdasar.controller

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.response.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.service.CRUDService
import com.techno.springbootdasar.service.MotorManagerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/crud")
class CRUDController(
    val crudService: CRUDService,
    val motorManager: MotorManagerService
) {
    @PostMapping("/insert")
    fun insert(@Valid @RequestBody req: ReqInsertDto): ResponseEntity<ResMessageDto<String>>{
        val res = crudService.insert(req)
        return ResponseEntity.ok(res)
    }
    @PutMapping("/update")
    fun update(
        @RequestParam uuid: UUID,
        @RequestBody req: ReqInsertDto): ResponseEntity<ResMessageDto<String>>{
        val res = crudService.update(uuid, req)
        return ResponseEntity.ok(res)
    }
    @GetMapping("/detail")
    fun detail(@RequestParam uuid: UUID): ResponseEntity<ResMessageDto<ResGetMotorDto>>{
        val res = crudService.detail(uuid)
        return ResponseEntity.ok(res)
    }
    @GetMapping("/motors")
    fun getAll(): ResponseEntity<ResMessageDto<List<ResGetMotorDto>>>{
        val res = crudService.list()
        return ResponseEntity.ok(res)
    }
    @DeleteMapping("/delete")
    fun delete(@RequestParam uuid: UUID): ResponseEntity<ResMessageDto<String>>{
        val res = crudService.delete(uuid)
        return ResponseEntity.ok(res)
    }
    @PostMapping("/insert/manager")
    fun insertManager(@Valid @RequestBody req: ReqInsertDto): ResponseEntity<ResMessageDto<String>>{
        val res = motorManager.insertManager(req)
        return ResponseEntity.ok(res)
    }
}