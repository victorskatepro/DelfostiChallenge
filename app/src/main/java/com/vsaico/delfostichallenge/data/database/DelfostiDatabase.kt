package com.vsaico.delfostichallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vsaico.delfostichallenge.data.database.dao.DelfostiDao
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity

@Database(entities = [PlaceEntity::class], version = 1)
abstract class DelfostiDatabase: RoomDatabase() {
    abstract fun getDelfostiDao(): DelfostiDao
}