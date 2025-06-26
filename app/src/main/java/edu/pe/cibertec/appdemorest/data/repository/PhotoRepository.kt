package edu.pe.cibertec.appdemorest.data.repository

import edu.pe.cibertec.appdemorest.data.api.RetrofiClient
import edu.pe.cibertec.appdemorest.util.safeApiCall

class PhotoRepository {
    private val api = RetrofiClient.apiService

    suspend fun getAllPhotos() = safeApiCall {
        api.getPhotos()
    }
    suspend fun getPhotoByAlbum(albumId: Int) = safeApiCall {
        api.getPhotosByAlbum(albumId)
    }

    suspend fun  getAllAlbums()=  safeApiCall {
        api.getAlbums()
    }
}