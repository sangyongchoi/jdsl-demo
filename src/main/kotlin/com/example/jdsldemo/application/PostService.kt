package com.example.jdsldemo.application

import com.example.jdsldemo.domain.Post
import com.example.jdsldemo.domain.PostRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class PostService(
    private val postRepository: PostRepository,
) {

    @Transactional
    fun create() {
        postRepository.save(
            Post(
                title = "title",
                content = "content"
            )
        )
    }

    fun findAll(): List<Post> {
        return postRepository.findAll()
    }
}