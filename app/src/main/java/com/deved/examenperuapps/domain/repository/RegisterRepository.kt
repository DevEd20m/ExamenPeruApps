package com.deved.examenperuapps.domain.repository

import com.deved.examenperuapps.data.network.model.UserNet
import com.deved.examenperuapps.domain.model.User

interface RegisterRepository {
    suspend fun registerUserWithFirebase(user: User)
}