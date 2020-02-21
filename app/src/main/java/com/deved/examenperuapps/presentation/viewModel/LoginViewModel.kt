package com.deved.examenperuapps.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deved.examenperuapps.domain.interactor.security.LoginUseCase
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.model.UserView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

class LoginViewModel(
    private val login: LoginUseCase, private val userMapper: UserMapper
) : ViewModel() {

    fun signInWithEmailAndPassword(user: UserView) = viewModelScope.launch {
        login.signInWithEmailAndPassword(userMapper.mapToEntity(user))
    }
     fun isSign(mAuth: FirebaseAuth):Boolean{
         return login.isSign(mAuth)
     }

}