package edu.pe.cibertec.appdemorest.util


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okio.IOException
import retrofit2.HttpException

//LLamadas de API

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            Result.success(apiCall())
        } catch (e: IOException) {
            Result.failure(Exception("Error en conexion"))
        } catch (e: HttpException) {
            val errorMsg = when (e.code()) {
                400 -> "Solictud incorrecta"
                401 -> "No autorizado"
                403 -> "Acceso prohibido"
                404 -> "No encontrado"
                500 -> "Server Internal error"
                502 -> "Bad Gateway error"
                else -> "Error desconocido ${e.code()}"
            }
            Result.failure(Exception(errorMsg))
        } catch (e: Exception){
            Result.failure(Exception("Error no esperado ${e.message}"))
        }

    }
}