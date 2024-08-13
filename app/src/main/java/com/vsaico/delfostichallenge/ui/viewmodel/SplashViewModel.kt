package com.vsaico.delfostichallenge.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vsaico.delfostichallenge.data.firebase.RemoteConfigRepository
import com.vsaico.delfostichallenge.data.firebase.RemoteConfigs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val remoteConfigRepository: RemoteConfigRepository
): ViewModel() {

    val showUnderMaintenance = MutableLiveData<Boolean>()
    val showAnimationEnd = MutableLiveData<Boolean>()

    fun validateRemoteConfigs() {
        val remoteConfigs = remoteConfigRepository.getConfigs()
        if (remoteConfigs.isUnderMaintenance) {
            showUnderMaintenance.value = true
        } else {
            showAnimationEnd.value = true
        }
    }


}