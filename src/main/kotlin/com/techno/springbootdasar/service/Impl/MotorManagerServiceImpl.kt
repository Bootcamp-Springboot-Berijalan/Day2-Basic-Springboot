package com.techno.springbootdasar.service.Impl

import com.techno.springbootdasar.domain.dto.request.ReqInsertDto
import com.techno.springbootdasar.domain.dto.response.ResMessageDto
import com.techno.springbootdasar.domain.entity.MotorEntity
import com.techno.springbootdasar.service.MotorManagerService
import jakarta.persistence.EntityManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MotorManagerServiceImpl: MotorManagerService {
    @Autowired
    lateinit var entityManager: EntityManager

    @Transactional
    override fun insertManager(req: ReqInsertDto): ResMessageDto<String> {
        val motor = MotorEntity(name = req.name, merk = req.merk)
        entityManager.persist(motor)
        return ResMessageDto()
    }
}