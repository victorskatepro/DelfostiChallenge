package com.vsaico.delfostichallenge.di

import android.content.Context
import androidx.room.Room
import com.vsaico.delfostichallenge.data.database.DelfostiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DELFOSTI_DATABASE_NAME = "delfosti_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DelfostiDatabase::class.java, DELFOSTI_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDelfostiDao(db: DelfostiDatabase) = db.getDelfostiDao()
}