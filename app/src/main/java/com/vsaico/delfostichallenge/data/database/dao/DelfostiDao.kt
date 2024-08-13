package com.vsaico.delfostichallenge.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.domain.model.Place

@Dao
interface DelfostiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlace(place: PlaceEntity)

    @Query("SELECT * FROM place_table")
    fun getAllPlaces(): List<PlaceEntity>

    @Query("SELECT * FROM place_table WHERE id = :id")
    fun getPlaceFromId(id: Int): PlaceEntity
}