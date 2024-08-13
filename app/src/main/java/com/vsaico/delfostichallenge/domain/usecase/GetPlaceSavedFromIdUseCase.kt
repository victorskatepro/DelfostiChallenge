package com.vsaico.delfostichallenge.domain.usecase

import com.vsaico.delfostichallenge.data.DelfostiRepository
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import javax.inject.Inject

class GetPlaceSavedFromIdUseCase @Inject constructor(
    private val repository: DelfostiRepository
) {
    suspend operator fun invoke(idPlace: Int): PlaceEntity? = repository.getPlaceSavedFromId(idPlace)
}