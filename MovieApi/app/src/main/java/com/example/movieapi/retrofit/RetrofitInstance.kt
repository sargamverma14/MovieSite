package com.example.movieapi.retrofit

import com.example.api.retrofit.ApiAlbum
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance{
    private val myRetrofit : Retrofit.Builder by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttp = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder().
        baseUrl("https://api.themoviedb.org/3/")
            .client(okHttp)
            .addConverterFactory(GsonConverterFactory.create())

    }

    val apiAlbum : ApiAlbum by lazy{
        myRetrofit.build().create(ApiAlbum::class.java)
    }
}