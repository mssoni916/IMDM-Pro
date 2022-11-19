package com.example.imdbpro.repository.api

import com.example.imdbpro.repository.model.MovieListResponse
import retrofit2.http.GET

interface MovieListApi {
    @GET("3/movie/now_playing")
    suspend fun fetchMovieList(): MovieListResponse
}