package com.lahsuak.apps.task1.ui.repo

import com.lahsuak.apps.task1.model.Results
import com.lahsuak.apps.task1.network.DataApi
import okhttp3.RequestBody
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val dataApi: DataApi) {
    fun pushData(mode:RequestBody,page:RequestBody): Call<Results> {
        return dataApi.pushData(mode,page)
    }
}