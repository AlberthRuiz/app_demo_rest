package edu.pe.cibertec.appdemorest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.pe.cibertec.appdemorest.data.model.Post
import edu.pe.cibertec.appdemorest.data.repository.PostRepository
import edu.pe.cibertec.appdemorest.util.UiState
import edu.pe.cibertec.appdemorest.util.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostListViewModel : ViewModel() {
    private val repository = PostRepository()

    private val _postsState = MutableStateFlow<UiState<List<Post>>>(UiState.Loading)
    val postsState: StateFlow<UiState<List<Post>>> = _postsState.asStateFlow()

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean> = _isRefreshing.asStateFlow()


    init {
        loadPosts()
    }

    fun loadPosts(){
        viewModelScope.launch {
            _postsState.value = UiState.Loading
            _postsState.value = repository.getAllPosts().toUiState()
            _isRefreshing.value = false
        }
    }

    fun refresh(){
        viewModelScope.launch {
            _isRefreshing.value= true
            _postsState.value = repository.getAllPosts().toUiState()
            _isRefreshing.value = false
        }
    }

}