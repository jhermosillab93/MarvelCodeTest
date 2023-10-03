package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class CharacterComicsResponse (
    @SerializedName("available")
    var available: Int?,

    @SerializedName("returned")
    var returned: Int? = null,

    @SerializedName("collectionURI")
    var collectionURI: String? = null,

    @SerializedName("items")
    var comicList: List<ComicInfo>? = null
)