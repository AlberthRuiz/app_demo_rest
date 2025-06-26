package edu.pe.cibertec.appdemorest.data.repository

import edu.pe.cibertec.appdemorest.data.api.RetrofiClient
import edu.pe.cibertec.appdemorest.data.model.Post
import edu.pe.cibertec.appdemorest.util.safeApiCall


class PostRepository{
    private val api = RetrofiClient.apiService

    suspend fun getAllPosts() = safeApiCall {
        api.getPost()
    }

    suspend fun getPost(postId: Int) = safeApiCall {
        api.getPost(postId)
    }

    suspend fun createPost(post: Post ) = safeApiCall {
        api.createPost(post)
    }

    suspend fun updatePos(postId: Int, post: Post)  {
        api.updtePost(postId,post)
    }

    suspend fun  deletePost(postId: Int) = safeApiCall {
        api.deletePost(postId)
    }

    suspend fun getCommentsByPost(postId: Int) = safeApiCall {
        api.getCommentsByPost(postId)
    }

}