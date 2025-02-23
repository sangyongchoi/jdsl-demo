package com.example.jdsldemo.domain

import jakarta.persistence.*

@Entity(name = "posts")
class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val content: String,
)