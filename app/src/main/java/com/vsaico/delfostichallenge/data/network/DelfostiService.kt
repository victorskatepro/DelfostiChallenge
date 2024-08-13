package com.vsaico.delfostichallenge.data.network

import com.vsaico.delfostichallenge.domain.model.Place
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class DelfostiService @Inject constructor(private val delfostiApi: DelfostiApi) {

    suspend fun getPlaces() : List<Place> {
        return withContext(Dispatchers.IO) {
            val res: Response<List<Place>> = delfostiApi.getPlaces()
            res.body()!!
        }
    }
}