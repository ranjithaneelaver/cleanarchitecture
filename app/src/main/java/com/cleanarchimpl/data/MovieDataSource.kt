package com.cleanarchimpl.data

import com.cleanarchimpl.presentar.framework.RemoteDataSource

class MovieDataSource (var remoteDataSource: RemoteDataSource)  {
    fun movies() = remoteDataSource.getData()
}
