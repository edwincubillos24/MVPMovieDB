package com.edwinacubillos.mvpmoviedb.presenter

import com.edwinacubillos.mvpmoviedb.model.MovieInteractor
import com.edwinacubillos.mvpmoviedb.model.MovieInteractorImpl
import com.edwinacubillos.mvpmoviedb.model.Result
import com.edwinacubillos.mvpmoviedb.view.MovieView

class MoviePresenterImpl(var movieView: MovieView): MoviePresenter {

    private var movieInteractor: MovieInteractor = MovieInteractorImpl(this)

    override fun loadListMovies() {
        movieInteractor.loadListMovies()
    }

    override fun showErrorLoadMovies(message: String?) {
        movieView.showErrorLoadMovies(message)
    }

    override fun sendListMovies(results: List<Result>?) {
        movieView.showListMovies(results)
    }


}