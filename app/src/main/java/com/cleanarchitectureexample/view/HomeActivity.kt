package com.samplekotlinapplication.user.view


import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.cleanarchitectureexample.R
import com.cleanarchitectureexample.databinding.ActivityMainBinding
import com.cleanarchitectureexample.view.adapter.MovieListAdapter
import com.domain.interfacelist.Emitter
import com.domain.interfacelist.GetData
import com.domain.module.MovieData
import com.domain.network.Constants
import com.samplekotlinapplication.user.viewmodel.HomeViewModel


class HomeActivity() : AppCompatActivity(), GetData {

    lateinit var binding: ActivityMainBinding

    private lateinit var viewmodel: HomeViewModel
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)//

        viewmodel.getMovieData(Constants.APIKEY, "Marvel", "movie", object : Emitter<MovieData> {
            override fun onNext(value: MovieData) {
                binding.progressBar.visibility = View.GONE
                updateRecyclerview(value)
            }

            override fun onError(error: Throwable?) {
                binding.progressBar.visibility = View.GONE
            }

            override fun onComplete() {
                binding.progressBar.visibility = View.VISIBLE

            }

        })

    }

    fun updateRecyclerview(movieData: MovieData) {
        val adapter = movieData?.Search?.let { it1 -> MovieListAdapter(it1, this, this) }!!
        binding.recyclerview.adapter = adapter;
    }

    override fun getData(data: MovieData) {
        TODO("Not yet implemented")
    }


}