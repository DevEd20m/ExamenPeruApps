package com.deved.examenperuapps.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deved.examenperuapps.domain.interactor.security.RegisterUseCase
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.model.UserView
import kotlinx.coroutines.launch

class RegisterViewModel(
    private val regiterUsesCase: RegisterUseCase,
    private val mapper: UserMapper
) :ViewModel(){

    fun registerUserWithFirebase(user: UserView)= viewModelScope.launch {
        regiterUsesCase.registerUserWithFirebase(mapper.mapToEntity(user))
    }
}