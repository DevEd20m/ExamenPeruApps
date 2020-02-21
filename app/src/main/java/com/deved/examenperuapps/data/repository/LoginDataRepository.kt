package com.deved.examenperuapps.data.repository

import com.deved.examenperuapps.data.mapper.DomainToDataMapper
import com.deved.examenperuapps.data.source.LoginDataSource
import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.LoginRepository

class LoginDataRepository(
) : LoginRepository {

    override suspend fun signInWithEmailAndPassword(user: User) {
        val loginDataSource = LoginDataSource()
        val domainToDataMapper = DomainToDataMapper()
        return loginDataSource.signInWithEmailAndPassword(domainToDataMapper.mapToEntity(user))
    }
}