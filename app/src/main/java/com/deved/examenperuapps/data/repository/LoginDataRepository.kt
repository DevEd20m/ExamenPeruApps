package com.deved.examenperuapps.data.repository

import com.deved.examenperuapps.data.mapper.DomainToDataMapper
import com.deved.examenperuapps.data.source.LoginDataSource
import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.LoginRepository

class LoginDataRepository(
//    private val domainToDataMapper: DomainToDataMapper
) : LoginRepository {
    override suspend fun logOut() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun signInWithEmailAndPassword(user: User) {
        val loginDataSource = LoginDataSource()
        val domainToDataMapper = DomainToDataMapper()
        loginDataSource.signInWithEmailAndPassword(domainToDataMapper.mapToEntity(user))
    }
}