package com.example.marvelcodetest.domain.model

data class CharacterDetails(
    val id: String,
    val name: String,
    val image: String,
    var description: String,
    val comicsNumber: Int,
    val seriesNumber: Int,
    val comicURL: String
)