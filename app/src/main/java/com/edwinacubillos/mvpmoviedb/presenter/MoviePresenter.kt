package com.edwinacubillos.mvpmoviedb.presenter

import com.edwinacubillos.mvpmoviedb.model.Result

interface MoviePresenter {

    fun loadListMovies()
    fun showErrorLoadMovies(message: String?)
    fun sendListMovies(results: List<Result>?)

}