package com.example.api.retrofit

import com.example.movieapi.retrofit.Albums
import com.example.movieapi.retrofit.Result
import retrofit2.Call
import retrofit2.http.GET

interface ApiAlbum {
    @GET("movie/popular?api_key=c94becbb20e697bf5ca1c749faaddb8d")
    fun getAlbum() : Call<List<Result>>
}