package com.example.imdbpro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imdbpro.databinding.MovieItemBinding
import com.example.imdbpro.repository.model.Movie

class MovieListViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        const val MOVIE_THUMBNAIL_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }

    fun bind(movie: Movie) {
        binding.apply {
            movieTitle.text = movie.title
            movieRating.text = "Rating - ${movie.rating}"
            Glide.with(binding.root.context)
                .load("$MOVIE_THUMBNAIL_BASE_URL${movie.thumbnailUrlPath}")
                .into(movieThumbnail)
            // TODO PLAYLIST REMAINING
        }

    }
}
class MovieListAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(layoutInflater, parent, false)
        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movieList.size
}