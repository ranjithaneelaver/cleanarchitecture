package com.samplekotlinapplication.user.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cleanarchitectureexample.R
import com.cleanarchitectureexample.databinding.ActivityMainBinding
import com.cleanarchitectureexample.view.MovieDEtailActivity
import com.cleanarchitectureexample.view.adapter.MovieListAdapter
import com.domain.interfacelist.Emitter
import com.domain.interfacelist.GetData
import com.domain.module.MovieData
import com.domain.utility.Constants
import com.samplekotlinapplication.user.viewmodel.HomeViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class HomeActivity() : AppCompatActivity(), GetData {

    lateinit var binding: ActivityMainBinding

    private val viewmodel: HomeViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


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
                    TODO("Not yet implemented")
                }

                override fun onComplete() {
                    TODO("Not yet implemented")
                }

            })
    }

    fun updateRecyclerview(movieData: MovieData) {
        val adapter = movieData?.Search?.let { it1 -> MovieListAdapter(it1, this, this) }!!
        binding.recyclerview.adapter = adapter;
    }

    override fun getData(data: MovieData) {

        MovieDEtailActivity.newStartIntent(this, data.imdbID)
        val intent = Intent(this, MovieDEtailActivity::class.java)
        intent.putExtra(Constants.MOVIEID, data.imdbID)
        startActivity(intent)
    }


}