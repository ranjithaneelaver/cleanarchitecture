package com.domain.repository

import com.domain.module.MovieData
import io.reactivex.Single

interface MovieRepository {
    fun getProjectList(
        url: String,
        apikey: String,
        mve: String?,
        type: String
    ): Single<MovieData>

}