package com.deved.examenperuapps.domain.repository

import com.deved.examenperuapps.domain.model.User

interface LoginRepository {
    suspend fun signInWithEmailAndPassword(user:User)
}