package com.vsaico.delfostichallenge.data

import com.vsaico.delfostichallenge.data.database.dao.DelfostiDao
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.data.network.DelfostiService
import com.vsaico.delfostichallenge.domain.model.Place
import javax.inject.Inject

class DelfostiRepository @Inject constructor(
    private val delfostiService: DelfostiService,
    private val delfostiDao: DelfostiDao
) {

    suspend fun getPlaces(): List<Place> {
        return delfostiService.getPlaces()
    }

    fun insertPlaceSaved(placeEntity: PlaceEntity) {
        return delfostiDao.insertPlace(placeEntity)
    }

    fun getPlacesFromDatabase(): List<PlaceEntity> {
        return delfostiDao.getAllPlaces()
    }

    fun getPlaceSavedFromId(idPlace: Int): PlaceEntity {
        return delfostiDao.getPlaceFromId(idPlace)
    }
}