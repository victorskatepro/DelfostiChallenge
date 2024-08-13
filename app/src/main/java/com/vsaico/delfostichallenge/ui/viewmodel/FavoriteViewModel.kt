package com.vsaico.delfostichallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaico.delfostichallenge.data.database.entities.PlaceEntity
import com.vsaico.delfostichallenge.domain.usecase.GetPlacesSaved
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getPlacesSaved: GetPlacesSaved
) : ViewModel() {

    val placesSaved = MutableLiveData<List<PlaceEntity>>()

    fun getMyPlaces() {
        viewModelScope.launch(context = Dispatchers.IO) {
            val result = getPlacesSaved()
            placesSaved.postValue(result)
        }
    }
}