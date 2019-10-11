package com.edwinacubillos.mvpmoviedb.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.edwinacubillos.mvpmoviedb.R
import com.edwinacubillos.mvpmoviedb.model.Repository
import com.edwinacubillos.mvpmoviedb.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie = intent?.getSerializableExtra("movie") as Result

        iv_favorite.setOnClickListener {
            val repository = Repository()
            repository.insertMovie(
                movie.id,
                movie.overview,
                movie.title,
                movie.posterPath,
                movie.releaseDate,
                movie.voteAverage)
        }
        updateUI(movie)
    }

    private fun updateUI(movie: Result) {
        val url_image = "https://image.tmdb.org/t/p/w500"
        tv_title.text = movie.title
        tv_releaseDate.text = movie.releaseDate
        tv_overview.text = movie.overview
        Picasso.get().load(url_image + movie.posterPath).into(iv_picture)
    }
}
