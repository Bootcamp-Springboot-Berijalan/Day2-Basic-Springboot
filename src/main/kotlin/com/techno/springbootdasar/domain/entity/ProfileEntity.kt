package com.techno.springbootdasar.domain.entity

import jakarta.persistence.*

@Entity
@Table(name = "mst_profile")
data class ProfileEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    val id: Int? = null,
    @Column(name = "name")
    var name: String? = null,
    @Column(name = "username")
    var username: String? = null,
    @Column(name = "email")
    var email: String? = null,
    @Column(name = "password")
    var password: String? = null,
)
