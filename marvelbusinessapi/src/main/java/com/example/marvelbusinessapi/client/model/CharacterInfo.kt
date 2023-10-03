package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName


data class CharacterInfo(
    @SerializedName("id")
    val characterId: String,

    @SerializedName("name")
    val characterName: String,

    @SerializedName("description")
    val characterDescription: String,

    @SerializedName("modified")
    val modified: String?= null,


    @SerializedName("resourceURI")
    val resourceURI: String?= null,

    @SerializedName("urls")
    val urls: List<URLResponse>,

    @SerializedName("thumbnail")
    val characterThumbnail: CharacterThumbnail,

    @SerializedName("comics")
    val comics: CharacterComicsResponse,

    @SerializedName("stories")
    val stories: CharacterComicsResponse,

    @SerializedName("events")
    val events: CharacterComicsResponse,

    @SerializedName("series")
    val series: CharacterComicsResponse
)