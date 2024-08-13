package com.vsaico.delfostichallenge.domain.usecase

import com.vsaico.delfostichallenge.data.DelfostiRepository
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import javax.inject.Inject

class GetPlacesSaved @Inject constructor(
    private val delfostiRepository: DelfostiRepository
) {

    suspend operator fun invoke(): List<PlaceEntity> {
        return delfostiRepository.getPlacesFromDatabase()
    }
}