package edu.pe.cibertec.appdemorest.util

sealed class UiState<out T>{
    // Estado de la carga de las peticiones
    object Loading : UiState<Nothing>()
    // Estado OK
    data class Success<T> (val data: T): UiState<T>()
    // Errores
    data class Error (val message: String): UiState<Nothing>()
}