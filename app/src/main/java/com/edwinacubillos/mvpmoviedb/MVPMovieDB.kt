package com.edwinacubillos.mvpmoviedb

import android.app.Application
import androidx.room.Room
import com.edwinacubillos.mvpmoviedb.model.MovieDataBase

class MVPMovieDB : Application() {

    companion object {
        lateinit var database: MovieDataBase
    }

    override fun onCreate() {
        super.onCreate()

        MVPMovieDB.database = Room.databaseBuilder(
            this,
            MovieDataBase::class.java,
            "movie_entity"
        ).build()
    }


}