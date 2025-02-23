package com.example.jdsldemo.controller

import com.example.jdsldemo.application.PostService
import com.example.jdsldemo.domain.Post
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val postService: PostService,
) {

    @PostMapping("/post")
    fun create() {
        postService.create()
    }

    @GetMapping("/posts")
    fun getAll(): List<Post> {
        return postService.findAll()
    }
}