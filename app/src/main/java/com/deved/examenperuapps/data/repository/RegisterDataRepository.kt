package com.deved.examenperuapps.data.repository

import com.deved.examenperuapps.data.mapper.DomainToDataMapper
import com.deved.examenperuapps.data.source.RegisterDataSource
import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.domain.repository.RegisterRepository

class RegisterDataRepository:RegisterRepository {

    override suspend fun registerUserWithFirebase(user: User) {
        val registerDataSourcer = RegisterDataSource()
        val domainToDataMapper = DomainToDataMapper()
        registerDataSourcer.registerUserWithFirebase(domainToDataMapper.mapToEntity(user))
    }
}