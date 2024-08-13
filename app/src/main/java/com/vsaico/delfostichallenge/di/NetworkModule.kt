package com.vsaico.delfostichallenge.di

import com.vsaico.delfostichallenge.data.network.DelfostiApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://private-cb1d6-defolstichallenge.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDelfostiApiClient(retrofit: Retrofit): DelfostiApi {
        return retrofit.create(DelfostiApi::class.java)
    }
}