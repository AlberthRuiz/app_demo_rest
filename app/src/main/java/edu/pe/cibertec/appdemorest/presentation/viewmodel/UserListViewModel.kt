package edu.pe.cibertec.appdemorest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.pe.cibertec.appdemorest.data.model.Photo
import edu.pe.cibertec.appdemorest.data.model.User
import edu.pe.cibertec.appdemorest.data.repository.UserRepository
import edu.pe.cibertec.appdemorest.util.UiState
import edu.pe.cibertec.appdemorest.util.toUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserListViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _userState = MutableStateFlow<UiState<List<User>>>(UiState.Loading)
    val userState: StateFlow<UiState<List<User>>> = _userState.asStateFlow()
    init {
        loadUsers()
    }
    fun loadUsers(){
        viewModelScope.launch {
            _userState.value = UiState.Loading
            _userState.value = repository.getAllUsers().toUiState()

        }
    }
}