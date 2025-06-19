package edu.pe.cibertec.appdemorest.data.api

import edu.pe.cibertec.appdemorest.data.model.Album
import edu.pe.cibertec.appdemorest.data.model.Comment
import edu.pe.cibertec.appdemorest.data.model.Photo
import edu.pe.cibertec.appdemorest.data.model.Post
import edu.pe.cibertec.appdemorest.data.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface JsonPlaceholderAPI {

    @GET("posts")
    suspend fun getPost(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post

    @POST("posts")
    suspend fun createPost(@Body post: Post): Post

    @PUT("posts/{id}")
    suspend fun updtePost(@Path("id") postId: Int, @Body post: Post): Post

    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") postId: Int)

    @GET("posts/{id}/comments")
    suspend fun getCommentsByPost(@Path("id") postId: Int): List<Comment>

    @GET("users")
    suspend fun getUser(): List<User>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @GET("photos")
    suspend fun getPhotos(): List<Photo>

    @GET("albums/{id}/photos")
    suspend fun getPhotosByAlbum(@Path("id") albumId : Int): List<Photo>

    @GET("albums")
    suspend fun getAlbums(): List<Album>

    @GET("users/{id}/albums")
    suspend fun getAlbumbyUser(@Path("id") userId: Int): List<Album>

}