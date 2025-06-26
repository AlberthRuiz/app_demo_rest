package edu.pe.cibertec.appdemorest.data.repository

import edu.pe.cibertec.appdemorest.data.api.RetrofiClient
import edu.pe.cibertec.appdemorest.util.safeApiCall

class  UserRepository{
    private val api = RetrofiClient.apiService

    suspend fun getAllUsers() = safeApiCall { api.getUser() }

    suspend fun getUser(userId: Int) = safeApiCall { api.getUser(userId) }
}