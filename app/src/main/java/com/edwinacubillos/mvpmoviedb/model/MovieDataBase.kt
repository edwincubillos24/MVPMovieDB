package com.edwinacubillos.mvpmoviedb.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MovieEntity::class), version= 1)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun MovieDao(): MovieDAO
}