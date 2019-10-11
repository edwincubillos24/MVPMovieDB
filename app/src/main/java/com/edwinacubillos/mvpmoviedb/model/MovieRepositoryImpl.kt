package com.edwinacubillos.mvpmoviedb.model

import com.edwinacubillos.mvpmoviedb.presenter.MoviePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl (var moviePresenter: MoviePresenter): MovieRepository {

    override fun loadListMovies() {
        val api_key="ff29f617b45b36aab5aa78a6fa04677f"

        ApiService.create()
            .getTopRated(api_key)
            .enqueue(object : Callback<Movies> {
                override fun onFailure(call: Call<Movies>, t: Throwable) {
                    moviePresenter.showErrorLoadMovies(t.message)
                }

                override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                    if (response.isSuccessful)
                        moviePresenter.sendListMovies(response.body()?.results)
                }

            })

    }
}