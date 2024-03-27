package com.techno.springbootdasar.repository

import com.techno.springbootdasar.domain.entity.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProfileRepository: JpaRepository<ProfileEntity, Int> {
    fun findByUsername(username: String): ProfileEntity?
    fun findByEmail(email: String): ProfileEntity?
    fun countByUsername(username: String): Int
    fun countByEmail(email: String): Int
    @Query("SELECT MAX(p.id) FROM ProfileEntity p")
    fun findMaxId(): Int
}