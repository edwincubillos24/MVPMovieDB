package com.edwinacubillos.mvpmoviedb.model

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.edwinacubillos.mvpmoviedb.MVPMovieDB

class Repository {

    var movieDao: MovieDAO = MVPMovieDB.database.MovieDao()

    fun insertMovie(
        id: Int,
        overview: String,
        title: String,
        posterPath: String,
        releaseDate: String,
        voteAverage: Double
    ) {
        val movie = MovieEntity(id, overview, title, posterPath, releaseDate, voteAverage)
        insertMovieTask(movie)
    }

    private fun insertMovieTask(movie: MovieEntity) {
        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void): Void? {
                movieDao.insertFavorite(movie)
                return null
            }
        }.execute()
    }

    fun getFavoritesMovies() : LiveData<List<MovieEntity>> {
        return movieDao.getFavoritesMovies()
    }






















}