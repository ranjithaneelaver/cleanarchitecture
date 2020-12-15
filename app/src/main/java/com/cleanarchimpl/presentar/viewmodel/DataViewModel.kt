package com.cleanarchimpl.presentar.viewmodel

import com.cleanarchimpl.domain.module.MovieData

class DataViewModel(movieData: MovieData) {

    val title = movieData.Title
    val image = movieData.Poster

}