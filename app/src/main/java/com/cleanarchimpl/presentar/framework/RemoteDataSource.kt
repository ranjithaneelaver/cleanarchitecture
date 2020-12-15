package com.cleanarchimpl.presentar.framework

import com.cleanarchimpl.presentar.utility.Constants

 class RemoteDataSource(var apiInterface: APIInterface) {
     fun getData() = apiInterface.getMovieList(url = "http://www.omdbapi.com/?",apikey = Constants.APIKEY,movie = "Marvel",type = "movie")
}