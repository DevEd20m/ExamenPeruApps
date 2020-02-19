package com.deved.examenperuapps.domain.interactor.security

import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository) {

    suspend fun signInWithEmailAndPassword(user:User){
        loginRepository.signInWithEmailAndPassword(user)
    }

    suspend fun logOut(){
        loginRepository.logOut()
    }
}