package com.deved.examenperuapps.data.cache.model

//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey

//@Entity(tableName = "tb_place")
data class CachePlace(
//    @PrimaryKey(autoGenerate = true)
    val Id:Int?,
//    @ColumnInfo(name = "departament")
    val Departament:String?,
//    @ColumnInfo(name = "description")
    val Description:String?,
//    @ColumnInfo(name = "foto1")
    val Foto1:String?,
//    @ColumnInfo(name = "foto2")
    val Foto2:String?,
//    @ColumnInfo(name = "createAt")
    val CreateAt:String?
)