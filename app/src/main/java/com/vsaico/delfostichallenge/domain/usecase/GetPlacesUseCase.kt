package com.vsaico.delfostichallenge.domain.usecase

import com.vsaico.delfostichallenge.data.DelfostiRepository
import com.vsaico.delfostichallenge.domain.model.Place
import javax.inject.Inject

class GetPlacesUseCase @Inject constructor(
    private val repository: DelfostiRepository
) {

    suspend operator fun invoke() : List<Place> {
        return repository.getPlaces()
    }
}