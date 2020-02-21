package com.deved.examenperuapps.data.network.model

import java.io.Serializable


data class PlaceNet(var Id: Int ?,
                    var Departament: String?,
                    var Decription: String?,
                    var Foto1: String?,
                    var Foto2: String?,
                    var CreateAt: String?
){
constructor() : this(null,"","","","","")
}