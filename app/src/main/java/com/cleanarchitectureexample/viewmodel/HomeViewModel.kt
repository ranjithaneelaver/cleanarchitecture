package com.samplekotlinapplication.user.viewmodel

import androidx.lifecycle.ViewModel
import com.data.RetrofitClient
import com.domain.module.MovieData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HomeViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    init {
        println("init function")
    }


    fun getMovieData(
        apikey: String,
        mve: String,
        type: String,
        objects: com.domain.interfacelist.Emitter<MovieData>
    ) {

        disposables.add(RetrofitClient.getClient.getMovieList(
            "http://www.omdbapi.com/?",
            apikey,
            mve,
            type
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe({ d ->
            })
            .subscribe(
                { result ->
                    objects.onNext(result)
                }, { error ->
                    objects.onError(error)
                }

            ))


    }


}