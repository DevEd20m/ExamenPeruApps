package com.deved.examenperuapps.data.cache.db

import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
import com.deved.examenperuapps.data.cache.db.dao.CachePlaceDao
import com.deved.examenperuapps.data.cache.model.CachePlace

//@Database(entities = [CachePlace::class], version = 1)
abstract class ExamenApp {
//    abstract fun cachePlaceDao(): CachePlaceDao
//    : RoomDatabase()
//
//    companion object {
//        private var INSTANCE: ExamenApp? = null
//        private const val DBNAME = "BdExamen"
//
//        fun getInstance(context: Context): ExamenApp? {
//            if (INSTANCE == null) {
//                synchronized(ExamenApp::class) {
//                    // init instance of BD
//                    INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        ExamenApp::class.java,
//                        DBNAME
//                    ).build()
//                }
//
//            }
//            return INSTANCE
//        }
//
//        fun destroyInstance() {
//            INSTANCE = null
//        }
//    }
}