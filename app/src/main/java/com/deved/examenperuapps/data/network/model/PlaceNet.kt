package com.deved.examenperuapps.data.network.model

import androidx.annotation.Keep
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

@Keep
@IgnoreExtraProperties
data class PlaceNet(val Id: Int?, val Departament:String?, val Decription: String?, val Foto1:String?, val Foto2:String?, val CreateAt: String?) : Serializable {

    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf("id" to Id,"departament" to Departament, "description" to Decription, "foto1" to Foto1 , "foto2" to Foto2,  "createAt" to CreateAt)
    }
}