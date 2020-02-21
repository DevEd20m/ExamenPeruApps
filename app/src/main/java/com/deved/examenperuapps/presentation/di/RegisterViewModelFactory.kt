package com.deved.examenperuapps.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deved.examenperuapps.domain.interactor.security.RegisterUseCase
import com.deved.examenperuapps.presentation.mapper.UserMapper
import com.deved.examenperuapps.presentation.viewModel.RegisterViewModel

class RegisterViewModelFactory (private val loginUseCase: RegisterUseCase,
                                private val userMapper: UserMapper
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RegisterViewModel(loginUseCase, userMapper) as T
    }
}