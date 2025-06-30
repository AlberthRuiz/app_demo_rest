package edu.pe.cibertec.appdemorest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.pe.cibertec.appdemorest.data.model.Photo
import edu.pe.cibertec.appdemorest.data.repository.PhotoRepository
import edu.pe.cibertec.appdemorest.util.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoGalleryViewModel: ViewModel(){
    private val repository = PhotoRepository()

    private val _photosState = MutableStateFlow<UiState<List<Photo>>>(UiState.Loading)
    val photState: StateFlow<UiState<List<Photo>>> = _photosState.asStateFlow()
    init {
        loadPhotos()
    }
    fun loadPhotos(){
        viewModelScope.launch {
            _photosState.value = UiState.Loading
            val result = repository.getAllPhotos()
            _photosState.value = result.fold (
                onSuccess = {
                    photos -> UiState.Success(photos.take(15))
                },
                onFailure = {
                    error -> UiState.Error(error.message ?: "Error desconocido")
                }

            )
        }
    }



}