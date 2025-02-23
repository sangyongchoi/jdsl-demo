package com.example.jdsldemo.infra

import com.example.jdsldemo.domain.Post
import com.example.jdsldemo.domain.PostRepository
import com.linecorp.kotlinjdsl.dsl.jpql.jpql
import com.linecorp.kotlinjdsl.render.jpql.JpqlRenderContext
import com.linecorp.kotlinjdsl.support.hibernate.extension.createQuery
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository

@Repository
class PostJdslRepository(
    @PersistenceContext
    private val entityManager: EntityManager,
) : PostRepository {

    private val context = JpqlRenderContext()

    override fun save(post: Post) {
        entityManager.persist(post)
    }

    override fun findAll(): List<Post> {
        val query = jpql {
            select(entity(Post::class))
                .from(
                    entity(Post::class)
                )
        }

        return entityManager.createQuery(query, context).resultList
    }
}