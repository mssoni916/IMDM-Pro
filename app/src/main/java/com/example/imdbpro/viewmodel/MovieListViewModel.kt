package com.example.imdbpro.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imdbpro.repository.MovieListRepository
import com.example.imdbpro.repository.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MovieListViewModel: ViewModel() {
    private val movieListRepository = MovieListRepository()

    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())
    val movieList = _movieList.asStateFlow()

    init {
        viewModelScope.launch {
            val response = movieListRepository.fetchMovieList()
            Log.d("MSSS", response.toString())
            _movieList.value = response.movieList
        }
    }
}