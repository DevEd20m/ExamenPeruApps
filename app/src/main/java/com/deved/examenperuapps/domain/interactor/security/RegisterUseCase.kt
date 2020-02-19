package com.deved.examenperuapps.domain.interactor.security

import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.RegisterRepository

class RegisterUseCase(private val registerRepository: RegisterRepository) {

    suspend fun registerUserWithFirebase(user: User){
        registerRepository.registerUserWithFirebase(user)
    }
}