package edu.pe.cibertec.appdemorest.util


fun <T> Result<T>.toUiState(): UiState<T>{
    return  fold (
        onSuccess = { UiState.Success(it) },
        onFailure = { UiState.Error(it.message ?: "Error desconocido")}
    )
}