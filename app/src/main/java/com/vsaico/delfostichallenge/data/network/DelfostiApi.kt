package com.vsaico.delfostichallenge.data.network

import com.vsaico.delfostichallenge.domain.model.Place
import com.vsaico.delfostichallenge.domain.model.PlacesResponse
import retrofit2.Response
import retrofit2.http.GET

interface DelfostiApi {

    @GET("v1/places")
    suspend fun getPlaces() : Response<List<Place>>
}