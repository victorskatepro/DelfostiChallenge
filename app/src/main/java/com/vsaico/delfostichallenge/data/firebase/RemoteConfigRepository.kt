package com.vsaico.delfostichallenge.data.firebase

interface RemoteConfigRepository {

    fun initConfigs()

    fun getConfigs(): RemoteConfigs
}