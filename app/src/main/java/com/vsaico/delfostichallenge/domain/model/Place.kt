package com.vsaico.delfostichallenge.domain.model

data class Place(
    val title: String,
    val description: String,
    val imageUrl: String,
    val address: String,
    val latitude: Double,
    val longitude: Double
)