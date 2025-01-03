package com.example.api.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieapi.retrofit.Albums
import com.example.movieapi.retrofit.Result
import com.example.movieapi.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RetrofitRepo {

    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>(true)
    private val postResponse: MutableLiveData<List<Result>> = MutableLiveData<List<Result>>()

    fun getAlbum(): LiveData<List<Result>> {
        val call = RetrofitInstance.apiAlbum.getAlbum()
        call.enqueue(object : Callback<List<Result>> {

            override fun onResponse(call: Call<List<Result>>, response: Response<List<Result>>) {
                if (response.isSuccessful){
                    isLoading.value = false
                    postResponse.value = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<Result>>, t: Throwable) {
                isLoading.value = false
                Log.d("TAG","onFailure: ${t.message}")
            }

        })
        return postResponse

    }

}