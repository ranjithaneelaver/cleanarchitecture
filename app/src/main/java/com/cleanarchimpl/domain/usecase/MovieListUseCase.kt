package com.cleanarchimpl.domain.usecase

import com.cleanarchimpl.domain.repository.MovieRepository
import com.cleanarchimpl.domain.module.MovieData
import io.reactivex.Single

class MovieListUseCase(private val movieRepository: MovieRepository) :
    SingleUseCase<MovieData, MovieListUseCase.Params>() {
    override fun callAPI(params: Params): Single<MovieData> {
        return with(params) {
            movieRepository.getProjectList(url, apikey, mve,type!!)
        }
    }
    class Params(
        val url: String,
        val apikey: String,
        val mve: String? = null,
        val type: String? = null
    )

}