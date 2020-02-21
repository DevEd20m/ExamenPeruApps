package com.deved.examenperuapps.presentation.mapper

import com.deved.examenperuapps.domain.model.Places
import com.deved.examenperuapps.presentation.model.PlacesView

class PlacesMapper:Mapper<Places,PlacesView> {
    override fun mapToEntity(type: PlacesView): Places {
        return Places(type.Id,type.Departament,type.Decription,type.Foto1,type.Foto2,type.CreateAt)
    }

}