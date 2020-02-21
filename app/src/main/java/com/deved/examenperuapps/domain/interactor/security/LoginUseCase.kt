package com.deved.examenperuapps.domain.interactor.security

import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth

class LoginUseCase(private val loginRepository: LoginRepository) {

    suspend fun signInWithEmailAndPassword(user:User){
        loginRepository.signInWithEmailAndPassword(user)
    }

    fun isSign(mAuth:FirebaseAuth):Boolean{
        mAuth?.let {
            return it.currentUser!=null
        }

    }
}