package com.cleanarchimpl.data

import com.cleanarchimpl.domain.module.MovieData
import com.cleanarchimpl.domain.repository.MovieRepository
import io.reactivex.Single

class HomeRepositoryImpl(var movieDataSource: MovieDataSource): MovieRepository {
    override fun getProjectList(
        url: String,
        apikey: String,
        mve: String?,
        type: String
    ): Single<MovieData> {
        return movieDataSource.movies()
                        .map { response ->
                val data = response
                data
            }
    }
}

