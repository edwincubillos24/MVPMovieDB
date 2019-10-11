package com.edwinacubillos.mvpmoviedb.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName="movie_entity")
class MovieEntity(
    @PrimaryKey
    var id: Int,
    var overview: String,
    var title: String,
    var posterPath: String,
    var releaseDate: String,
    var voteAverage: Double
) : Serializable