package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class ComicInfo (

    @SerializedName("resourceURI")
    var resourceURI: String,

    @SerializedName("name")
    var name: String
)