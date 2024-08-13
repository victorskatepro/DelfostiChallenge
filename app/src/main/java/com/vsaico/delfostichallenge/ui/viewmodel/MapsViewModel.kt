package com.vsaico.delfostichallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vsaico.delfostichallenge.domain.model.Place
import com.vsaico.delfostichallenge.domain.usecase.GetPlacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val getPlacesUseCase: GetPlacesUseCase,
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
}