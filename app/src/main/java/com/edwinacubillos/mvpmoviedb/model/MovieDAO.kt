package com.edwinacubillos.mvpmoviedb.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDAO {

    @Insert
    fun insertFavorite(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie_entity")
    fun getFavoritesMovies(): LiveData<List<MovieEntity>>


}