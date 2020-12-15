package com.cleanarchimpl.presentar.framework

import com.cleanarchimpl.domain.module.MovieData
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIInterface {

    @GET
    fun getMovieList(
        @Url url: String,
        @Query("apikey") apikey: String,
        @Query("s") movie: String,
        @Query("type") type: String
    ): io.reactivex.Single<MovieData>
}