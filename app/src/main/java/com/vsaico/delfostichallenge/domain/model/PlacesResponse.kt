package com.vsaico.delfostichallenge.domain.model

import com.google.gson.annotations.SerializedName

data class PlacesResponse (
    @SerializedName("tourist_spots")
    val places: List<Place>
)