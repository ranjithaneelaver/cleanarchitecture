package com.domain.network;

import com.domain.module.MovieData
import org.jetbrains.annotations.Nullable


class Resource private constructor(
    status: Status,
    @Nullable data: MovieData?,
    @Nullable error: Throwable?
) {
    val status: Status

    @Nullable
    val data: MovieData?

    @Nullable
    val error: Throwable?

    companion object {
        fun loading(): Resource {
            return Resource(Status.LOADING, null, null)
        }

        fun success(data: MovieData?): Resource {
            return Resource(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable?): Resource {
            return Resource(Status.ERROR, null, error)
        }
    }

    init {
        this.status = status
        this.data = data
        this.error = error
    }
}