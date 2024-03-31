package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqProfileDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.dto.response.ResProfileDto
import com.techno.springbootdasar.domain.entity.ProfileEntity
import com.techno.springbootdasar.exception.DataHasSpacesException
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.exception.DataNotUniqueException
import com.techno.springbootdasar.repository.ProfileRepository
import com.techno.springbootdasar.rest.AvatarClient
import com.techno.springbootdasar.service.ProfileService
import org.springframework.stereotype.Service

@Service
class ProfileServiceImpl(
    val profileRepository: ProfileRepository,
    val avatarClient: AvatarClient
): ProfileService {
    fun checkDupe(username: String, email: String){
        val usedUsername = profileRepository.findByUsername(username)
        val usedEmail = profileRepository.findByEmail(email)
        if(usedUsername != null){
            if(usedEmail != null){
                throw DataNotUniqueException("Username & Email already used")
            }else{
                throw DataNotUniqueException("Username already used")
            }
        }
        if(usedEmail != null){
            throw DataNotUniqueException("Email already used")
        }
    }

    fun checkDupeUpdate(username: String, email: String){
        val usedUsername = profileRepository.countByUsername(username)
        val usedEmail = profileRepository.countByEmail(email)
        if(usedUsername > 1){
            if(usedEmail > 1){
                throw DataNotUniqueException("Username & Email already used")
            }else{
                throw DataNotUniqueException("Username already used")
            }
        }
        if(usedEmail > 1){
            throw DataNotUniqueException("Email already used")
        }
    }

    override fun create(seed: String, req: ReqProfileDto): ResMessageDto<String> {
        checkDupe(req.username, req.email)
        val getAvatar = avatarClient.getAvatar(seed)
        var avatar = ""
        if(getAvatar.statusCode.is2xxSuccessful){
            avatar = String(getAvatar.body?: byteArrayOf())
        }
        val input = ProfileEntity(
            name = req.name,
            username = req.username,
            email = req.email,
            password = req.password,
            avatar = avatar
        )
        profileRepository.save(input)
        return ResMessageDto()
    }

    override fun readAll(): ResMessageDto<List<ResProfileDto>> {
        var profiles = profileRepository.findAll()
        val res = arrayListOf<ResProfileDto>()
        for (profile in profiles){
            val data = ResProfileDto(
                id = profile.id,
                name = profile.name,
                username = profile.username,
                email = profile.email,
                password = profile.password,
                avatar = profile.avatar
            )
            res.add(data)
        }
        return ResMessageDto(data = res)
    }

    override fun readById(id: Int): ResMessageDto<ResProfileDto> {
        val idExist = profileRepository.findById(id)
        if(idExist.isEmpty)
            throw DataNotFoundException("Id not found")
        val res = ResProfileDto(
            id = idExist.get().id!!,
            name = idExist.get().name!!,
            username = idExist.get().username!!,
            email = idExist.get().email!!,
            password = idExist.get().password!!,
            avatar = idExist.get().avatar!!
        )
        return ResMessageDto(data = res)
    }

    override fun update(id: Int, seed: String, req: ReqProfileDto): ResMessageDto<String> {
        val idExist = profileRepository.findById(id)
        if(idExist.isEmpty)
            throw DataNotFoundException("Id not found")
        checkDupeUpdate(req.username, req.email)
        val getAvatar = avatarClient.getAvatar(seed)
        var avatar = ""
        if(getAvatar.statusCode.is2xxSuccessful){
            avatar = String(getAvatar.body?: byteArrayOf())
        }
        idExist.get().name = req.name
        idExist.get().username = req.username
        idExist.get().email = req.email
        idExist.get().password = req.password
        idExist.get().avatar = avatar
        profileRepository.save(idExist.get())
        return ResMessageDto()
    }

    override fun delete(id: Int): ResMessageDto<String> {
        val deleted = profileRepository.deleteById(id)
        return ResMessageDto()
    }
}