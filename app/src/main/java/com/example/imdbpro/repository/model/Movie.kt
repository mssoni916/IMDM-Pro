package com.example.imdbpro.repository.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val id: Long,
    val title: String,
    @Json(name = "backdrop_path") val thumbnailUrlPath: String,
    @Json(name = "vote_average") val rating: Float
)