package com.data.repository

import com.data.network.RetrofitClient
import com.domain.repository.MovieRepository
import com.domain.module.MovieData
import io.reactivex.Single

class HomeRepositoryImpl(
    var restClient: RetrofitClient
) : MovieRepository {

    override fun getProjectList(
        url: String,
        apikey: String,
        mve: String?,
        type: String
    ): Single<MovieData> {
        return restClient.getClient.getMovieList(url, apikey, mve!!, type)
            .map { response ->
                val data = response

                data
            }
    }

}