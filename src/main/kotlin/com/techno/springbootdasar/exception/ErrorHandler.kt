package com.techno.springbootdasar.exception

import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
class ErrorHandler {
    @ExceptionHandler (MethodArgumentNotValidException::class)
    fun handleArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<Any>{
        val errors = mutableListOf<String>()
        exception.bindingResult.fieldErrors.forEach{
            errors.add(it.defaultMessage!!)
        }
        val result = mapOf<String, Any>(
            "status" to "F",
            "error" to "field",
            "message" to errors
        )
        return ResponseEntity.badRequest().body(result)
    }
    @ExceptionHandler(DataNotFoundException::class)
    fun handleDataNotFound(exception: RuntimeException): ResponseEntity<ResMessageDto<String>>{
        exception.printStackTrace()
        return ResponseEntity.badRequest().body(ResMessageDto(
            status = 400, message = exception.message.toString()
        ))
    }
    @ExceptionHandler(DataNotUniqueException::class)
    fun handleDataNotUnique(exception: DataNotUniqueException): ResponseEntity<ResMessageDto<String>>{
        exception.printStackTrace()
        return ResponseEntity.badRequest().body(
            ResMessageDto(
            status = 400, message = exception.message.toString()
            )
        )
    }
    @ExceptionHandler(DataHasSpacesException::class)
    fun handleDataHasSpaces(exception: DataHasSpacesException): ResponseEntity<ResMessageDto<String>>{
        exception.printStackTrace()
        return ResponseEntity.badRequest().body(ResMessageDto(
            status = 400, message = exception.message.toString()
        ))
    }
}