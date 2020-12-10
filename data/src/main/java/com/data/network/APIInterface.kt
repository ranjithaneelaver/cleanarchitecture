package com.data.network


import com.domain.module.MovieData
import com.domain.module.MovieDetailModule

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import io.reactivex.Observable


interface APIInterface {

    @GET()
     fun getMovieList(@Url url:String, @Query("apikey")  apikey:String, @Query("s") movie:String, @Query("type") type:String ) : io.reactivex.Single<MovieData>


    @GET()
     fun getMovieDetails(@Url url:String, @Query("apikey")  apikey:String, @Query("i") movie:String ) : Observable<MovieDetailModule>
}