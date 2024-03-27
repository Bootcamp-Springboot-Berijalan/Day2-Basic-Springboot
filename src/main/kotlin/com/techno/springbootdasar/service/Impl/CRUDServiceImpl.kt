package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.response.ResGetMotorDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.repository.MotorRepository
import com.techno.springbootdasar.service.CRUDService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CRUDServiceImpl(
    val motorRepository: MotorRepository
): CRUDService {
    override fun insert(req: ReqInsertDto): ResMessageDto<String> {
        val input = MotorEntity(
            id = UUID.randomUUID(),
            name = req.name,
            merk = req.merk
        )
        motorRepository.save(input)
        return ResMessageDto()
    }

    override fun update(uuid: UUID, req: ReqInsertDto): ResMessageDto<String> {
        val idExist = motorRepository.findById(uuid)
        if(idExist.isEmpty)
            throw DataNotFoundException("Id not found")
        idExist.get().name = req.name
        idExist.get().merk = req.merk
        motorRepository.save(idExist.get())
        return ResMessageDto()
    }

    override fun detail(uuid: UUID): ResMessageDto<ResGetMotorDto> {
        val idExist = motorRepository.findById(uuid)
        if(idExist.isEmpty)
            throw DataNotFoundException("Id not found")
        val res = ResGetMotorDto(
            id = idExist.get().id!!,
            name = idExist.get().name!!,
            merk = idExist.get().merk!!
        )
        return ResMessageDto(data = res)
    }

    override fun list(): ResMessageDto<List<ResGetMotorDto>> {
        val motorList = motorRepository.findAll()
        val res = arrayListOf<ResGetMotorDto>()
        for (motor in motorList){
            val data = ResGetMotorDto(
                id = motor.id,
                name = motor.name,
                merk = motor.merk
            )
            res.add(data)
        }
        return ResMessageDto(data = res)
    }

    override fun delete(uuid: UUID): ResMessageDto<String> {
        val deleted = motorRepository.deleteById(uuid)
        return ResMessageDto()
    }
}