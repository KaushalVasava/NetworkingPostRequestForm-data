package com.lahsuak.apps.task1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lahsuak.apps.task1.model.Results
import com.lahsuak.apps.task1.ui.repo.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "MainViewModel"

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {
    val myResponse: MutableLiveData<Response<Results>> = MutableLiveData()

    fun pushResults(mode: String, page: String) {
        viewModelScope.launch {
            val body = RequestBody.create(MediaType.parse("multipart/form-data"), mode)
            val body2 = RequestBody.create(MediaType.parse("multipart/form-data"), page)
            val call = repository.pushData(body, body2)
            call.enqueue(object : Callback<Results> {
                override fun onResponse(call: Call<Results>, response: Response<Results>) {
                    if (response.isSuccessful) {
                        myResponse.value = response
                        Log.d(TAG, "onResponse: $response ${response.code()}")
                    } else {
                        Log.d(TAG, "onResponse: else ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<Results>, t: Throwable) {
                    Log.d(TAG, "onResponse ERROR")
                }
            })
        }
    }

}