package com.edwinacubillos.mvpmoviedb.model

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/top_rated")
    fun getTopRated(@Query("api_key") apiKey: String): Call<Movies>

    companion object{
        val urlApi = "https://api.themoviedb.org/3/"

        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}

























