package com.deved.examenperuapps.presentation.mapper

import com.deved.examenperuapps.domain.model.User
import com.deved.examenperuapps.presentation.model.UserView

class UserMapper:Mapper<User,UserView> {
    override fun mapToEntity(type: UserView): User {
        return User(null,type.Name,type.LastName,type.Email,type.Password)
    }

}