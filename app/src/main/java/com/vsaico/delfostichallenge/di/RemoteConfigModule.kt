package com.vsaico.delfostichallenge.di

import com.vsaico.delfostichallenge.data.firebase.RemoteConfigRepository
import com.vsaico.delfostichallenge.data.firebase.RemoteConfigRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteConfigModule {

    @Provides
    @Singleton
    fun bindConfig(remoteConfigRepoRepositoryImpl: RemoteConfigRepositoryImpl): RemoteConfigRepository {
        remoteConfigRepoRepositoryImpl.initConfigs()
        return RemoteConfigRepositoryImpl()
    }
}