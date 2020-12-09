package com.cleanarchitectureexample.viewmodel

import com.domain.module.MovieData

class DataViewModel(val movieData: MovieData) {

    val title = movieData.Title
    val image = movieData.Poster

}