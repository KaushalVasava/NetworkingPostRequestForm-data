package com.lahsuak.apps.task1.di

import androidx.lifecycle.ViewModel
import com.lahsuak.apps.task1.network.DataApi
import com.lahsuak.apps.task1.ui.repo.DataRepository
import com.lahsuak.apps.task1.ui.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val BASE_URL = "https://www.devops.tileswale.com"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideDataApi(retrofit: Retrofit): DataApi = retrofit.create(DataApi::class.java)
}