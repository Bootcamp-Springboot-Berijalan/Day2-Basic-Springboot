package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqLoginDto
import com.techno.springbootdasar.domain.dto.request.ReqLoginJwtDto
import com.techno.springbootdasar.domain.dto.response.ResLoginDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.service.LoginService
import com.techno.springbootdasar.util.JWTGenerator
import org.springframework.stereotype.Service

@Service
class LoginServiceImpl(
    val profileRepository: ProfileRepository
): LoginService {
    override fun login(req: ReqLoginDto): ResLoginDto {
        val token: String
        val id: String
        val userExist = profileRepository.findByUsername(req.username)
        if (userExist == null){
            throw DataNotFoundException("Username does not exist")
        }else{
            if(userExist.password != req.password){
                throw IllegalArgumentException("Invalid password")
            }
            val userData = ReqLoginJwtDto(
                id = userExist.id.toString(),
                name = userExist.name!!,
                email = userExist.email!!,
                username = userExist.username!!
            )
            id = userExist.id.toString()
            token = JWTGenerator().loginJWT(userData)
        }
        return ResLoginDto(id = id, token = token)
    }
}