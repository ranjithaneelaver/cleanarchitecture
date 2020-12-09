package com.samplekotlinapplication.user.viewmodel

import androidx.lifecycle.ViewModel
import com.data.RetrofitClient
import com.domain.interfacelist.Emitter
import com.domain.module.MovieData
import com.domain.module.MovieDetailModule
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class HomeViewModel(val retrofitclient:RetrofitClient) : ViewModel() {
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

        disposables.add(retrofitclient.getClient.getMovieList(
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

    fun getMovieDetail(apikey:String,mveId:String,objects : Emitter<MovieDetailModule>){
        disposables.add(retrofitclient.getClient.getMovieDetails(
            "http://www.omdbapi.com/?",
            apikey, mveId)
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

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }


}