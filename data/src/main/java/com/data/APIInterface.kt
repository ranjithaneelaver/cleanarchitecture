package com.data


import com.domain.module.MovieData
import com.domain.module.MovieDetailModule
import com.domain.network.Resource

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.*
import io.reactivex.Observable


interface APIInterface {

    @GET()
     fun getMovieList(@Url url:String, @Query("apikey")  apikey:String, @Query("s") movie:String, @Query("type") type:String ) : io.reactivex.Observable<MovieData>


    @GET()
    suspend fun getMovieDetails(@Url url:String, @Query("apikey")  apikey:String, @Query("i") movie:String ) : MovieDetailModule
}