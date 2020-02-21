package com.deved.examenperuapps.data.mapper

import com.deved.examenperuapps.data.network.model.PlaceNet
import com.deved.examenperuapps.domain.model.Places

class PlacesToDataMapper:Mapper<Places,PlaceNet> {
    override fun mapFromEntity(type: Places): PlaceNet {
        return PlaceNet(type.Id,type.Departament,type.Decription,type.Foto1,type.Foto2,type.CreateAt)
    }

    override fun mapToEntity(type: PlaceNet): Places {
        return Places(type.Id,type.Departament,type.Decription,type.Foto1,type.Foto2,type.CreateAt)
    }

}