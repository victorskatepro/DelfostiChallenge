package com.vsaico.delfostichallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.domain.usecase.GetPlaceSavedFromIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailPlaceViewModel @Inject constructor(
    private val getPlaceSavedFromIdUseCase: GetPlaceSavedFromIdUseCase
):ViewModel() {

    val placeEntity = MutableLiveData<PlaceEntity>()

    fun getPlaceSavedFromId(idPlace: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getPlaceSavedFromIdUseCase(idPlace)
            result?.let {
                placeEntity.postValue(it)
            }
        }
    }
}