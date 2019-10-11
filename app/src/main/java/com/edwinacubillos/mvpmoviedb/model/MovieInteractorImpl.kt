package com.edwinacubillos.mvpmoviedb.model

import com.edwinacubillos.mvpmoviedb.presenter.MoviePresenter

class MovieInteractorImpl(var moviePresenter: MoviePresenter) : MovieInteractor{

    private var movieRepository: MovieRepository = MovieRepositoryImpl(moviePresenter)

    override fun loadListMovies() {
        movieRepository.loadListMovies()
    }

}