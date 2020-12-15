package com.cleanarchimpl.presentar.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cleanarchimpl.R
import com.cleanarchimpl.databinding.ActivityMainBinding
import com.cleanarchimpl.view.adapter.MovieListAdapter

import com.cleanarchimpl.domain.interfacelist.Emitter
import com.cleanarchimpl.domain.interfacelist.GetData
import com.cleanarchimpl.domain.module.MovieData
import com.cleanarchimpl.presentar.utility.Constants
import com.cleanarchimpl.presentar.viewmodel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), GetData {
    lateinit var binding: ActivityMainBinding
    private val viewmodel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        getData()

    }

    fun updateRecyclerview(movieData: MovieData) {
        val adapter = movieData?.Search?.let { it1 -> MovieListAdapter(it1, this, this) }!!
        binding.recyclerview.adapter = adapter
    }

    override fun getData(data: MovieData) {

        MovieDEtailActivity.newStartIntent(this, data.imdbID)
        val intent = Intent(this, MovieDEtailActivity::class.java)
        intent.putExtra(Constants.MOVIEID, data.imdbID)
        startActivity(intent)
    }

    fun  getData() {
        viewmodel.requestPageData(
            "http://www.omdbapi.com/?",
            Constants.APIKEY,
            "Marvel",
            "movie",
            object : Emitter<MovieData> {
                override fun onNext(value: MovieData) {
                    binding.progressBar.visibility = View.GONE
                    println("movie" + value)
                    updateRecyclerview(value)
                }

                override fun onError(error: Throwable?) {
                }

                override fun onComplete() {
                }

            })
    }


}