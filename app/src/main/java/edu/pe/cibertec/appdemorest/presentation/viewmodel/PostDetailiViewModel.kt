package edu.pe.cibertec.appdemorest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.pe.cibertec.appdemorest.data.model.Comment
import edu.pe.cibertec.appdemorest.data.model.Photo
import edu.pe.cibertec.appdemorest.data.model.Post
import edu.pe.cibertec.appdemorest.data.repository.PostRepository
import edu.pe.cibertec.appdemorest.util.UiState
import edu.pe.cibertec.appdemorest.util.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostDetailiViewModel : ViewModel(){
    private val repository = PostRepository()

    private val _postsState = MutableStateFlow<UiState<Post>>(UiState.Loading)
    val postState: StateFlow<UiState<Post>> = _postsState.asStateFlow()

    private val _commentState = MutableStateFlow<UiState<List<Comment>>>(UiState.Loading)
    val commentState : StateFlow<UiState<List<Comment>>> = _commentState.asStateFlow()

    fun loadPostDetail(postId: Int){
        viewModelScope.launch {
            _postsState.value = UiState.Loading
            _postsState.value = repository.getPost(postId).toUiState()

            _commentState.value = UiState.Loading
            _commentState.value = repository.getCommentsByPost(postId).toUiState()

        }
    }

}