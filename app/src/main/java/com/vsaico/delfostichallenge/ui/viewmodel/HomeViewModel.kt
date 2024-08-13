package com.vsaico.delfostichallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.domain.model.Place
import com.vsaico.delfostichallenge.domain.usecase.GetPlacesUseCase
import com.vsaico.delfostichallenge.domain.usecase.SavePlaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlacesUseCase: GetPlacesUseCase,
    private val savePlace: SavePlaceUseCase
): ViewModel() {

    val places = MutableLiveData<List<Place>>()
    val isLoading = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch(context = Dispatchers.IO) {
            isLoading.postValue(true)
            val resultPlaces = getPlacesUseCase()
            places.postValue(resultPlaces)
            isLoading.postValue(false)
        }
    }

    fun savePlace(place: Place) {
        viewModelScope.launch(context = Dispatchers.IO) {
            val placeEntity = PlaceEntity(
                title = place.title,
                description = place.description,
                imageUrl = place.imageUrl,
                address = place.address,
                latitude = place.latitude,
                longitude = place.longitude
            )
            savePlace(placeEntity)
        }
    }
}