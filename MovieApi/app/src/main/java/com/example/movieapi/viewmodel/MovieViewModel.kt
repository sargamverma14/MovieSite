package com.example.movieapi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.api.repository.RetrofitRepo
import com.example.movieapi.retrofit.Result
import com.example.movieapi.retrofit.RetrofitInstance

class MovieViewModel :ViewModel() {
    fun getMovie():LiveData<List<Result>>{
        return RetrofitRepo.getAlbum()
    }

}