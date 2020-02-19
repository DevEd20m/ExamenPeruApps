package com.deved.examenperuapps.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.domain.interactor.security.LoginUseCase
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.viewModel.LoginViewModel

class ViewModelFactory (private val loginUseCase: LoginUseCase,
                        private val userMapper: UserMapper):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(loginUseCase,userMapper)as T
    }

}