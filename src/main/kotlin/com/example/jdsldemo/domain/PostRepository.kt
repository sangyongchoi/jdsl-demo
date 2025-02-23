package com.example.jdsldemo.domain

interface PostRepository {
    fun save(post: Post)
    fun findAll(): List<Post>
}