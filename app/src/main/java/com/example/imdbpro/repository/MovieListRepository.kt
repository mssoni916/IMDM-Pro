package com.example.imdbpro.repository

import com.example.imdbpro.repository.api.MovieListApi
import com.example.imdbpro.repository.api.MovieListApiIntercepter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class MovieListRepository {
    private val movieListApi: MovieListApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(MovieListApiIntercepter())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        movieListApi = retrofit.create()
    }

    suspend fun fetchMovieList() = movieListApi.fetchMovieList()
}