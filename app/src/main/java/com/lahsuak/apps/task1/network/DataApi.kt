package com.lahsuak.apps.task1.network

import com.lahsuak.apps.task1.model.Results
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.POST

interface DataApi {
    @Multipart
    @POST("/api/v26/company_list_by_category")
    fun pushData(
        @Part("mode") mode:RequestBody,
        @Part("page") page: RequestBody
    ): Call<Results>
}