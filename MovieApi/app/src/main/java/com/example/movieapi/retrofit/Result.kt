package com.example.movieapi.retrofit

data class Result(
    val adult:Boolean,
    val backdrop_path :String,
    val genre_ids : ArrayList<Int>,
    val id:Int,
    val original_language:String,
    val original_title:String,
    val overview:String,
    val popularity:Long,
    val poster_path:String,
    val release_date: String,
    val title:String,
    val video:Boolean,
    val vote_average:Float,
    val vote_count:Int
)
