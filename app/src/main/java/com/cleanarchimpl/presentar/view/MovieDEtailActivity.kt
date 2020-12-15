package com.cleanarchimpl.presentar.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cleanarchimpl.R
import com.cleanarchimpl.databinding.ActivityDetailBinding
import com.cleanarchimpl.presentar.utility.Constants


class MovieDEtailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
  //  private val viewmodel: HomeViewModel by viewModel()

    companion object {

        fun newStartIntent(context: Context, id: String): Intent {
            val intent = Intent(context, MovieDEtailActivity::class.java)
            intent.putExtra(Constants.MOVIEID, id)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        setSupportActionBar(binding.toolbar)
        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)




      /*  viewmodel.getMovieDetail(
            Constants.APIKEY,
            intent.getStringExtra(Constants.MOVIEID),
            object : Emitter<MovieDetailModule> {


                override fun onError(error: Throwable?) {
                    binding.progressBar.visibility = View.GONE
                }

                override fun onComplete() {
                    binding.progressBar.visibility = View.VISIBLE

                }

                override fun onNext(value: MovieDetailModule) {
                    binding.progressBar.visibility = View.GONE
                    binding.setVariable(BR.item, value)
                    // Glide.with(this).load(value?.Poster).into(binding.imageview)

                }

            })*/



        binding.toolbar.setOnClickListener {
            onBackPressed()
        }


    }

}