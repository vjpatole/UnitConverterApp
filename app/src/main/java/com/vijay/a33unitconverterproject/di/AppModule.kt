package com.vijay.a33unitconverterproject.di

import android.app.Application
import androidx.room.Room
import com.vijay.a33unitconverterproject.data.ConverterDatabase
import com.vijay.a33unitconverterproject.data.ConverterRepository
import com.vijay.a33unitconverterproject.data.ConverterRepositoryIMPL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Author : vijay
 * Created On : 7/31/24
 *Class :
 **/

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application): ConverterDatabase{
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "converter_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDatabase): ConverterRepository{
        return ConverterRepositoryIMPL(db.converterDao)
    }
}