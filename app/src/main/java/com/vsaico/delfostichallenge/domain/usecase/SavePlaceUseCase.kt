package com.vsaico.delfostichallenge.domain.usecase

import com.vsaico.delfostichallenge.data.DelfostiRepository
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import javax.inject.Inject

class SavePlaceUseCase @Inject constructor(
    private val delfostiRepository: DelfostiRepository
) {
    operator fun invoke(placeEntity: PlaceEntity) {
        delfostiRepository.insertPlaceSaved(placeEntity)
    }
}