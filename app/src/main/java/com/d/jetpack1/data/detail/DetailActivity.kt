package com.d.jetpack1.data.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.d.jetpack1.R
import com.d.jetpack1.utils.MOVIE_ID
import com.d.jetpack1.utils.requestOption
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.items_movie.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val viewModel = ViewModelProviders.of(this).get(DetailFilmViewModel::class.java)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(MOVIE_ID)) {
            viewModel.movieEntity = intent.getParcelableExtra(MOVIE_ID)
            val movie = viewModel.movieEntity

            Glide.with(this@DetailActivity)
                .load(movie?.img)
                .apply(this@DetailActivity requestOption 5)
                .into(image_poster)

            text_title.text = movie?.title
            text_desc.text = movie?.overview
            title = movie?.title
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
