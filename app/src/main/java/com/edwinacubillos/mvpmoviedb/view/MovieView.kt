package com.edwinacubillos.mvpmoviedb.view

import com.edwinacubillos.mvpmoviedb.model.Result

interface MovieView {
    fun showErrorLoadMovies(message: String?)
    fun showListMovies(results: List<Result>?)
}