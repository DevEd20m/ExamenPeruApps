package com.deved.examenperuapps.data.mapper

import com.deved.examenperuapps.data.network.model.UserNet
import com.deved.examenperuapps.domain.model.User

/**
 * Map a [UserNet] to and from a [User]
 */
class DomainToDataMapper:Mapper<UserNet,User> {
    override fun mapFromEntity(type: UserNet): User {
        return User(type.Id,type.Name,type.LastName,type.Email,type.Password)
    }

    override fun mapToEntity(type: User): UserNet {
        // todo la location está nula, verificar si lo necesitaremos luego
        return UserNet(type.Id,type.Name,type.LastName,type.Email,type.Password,null)

    }

}


