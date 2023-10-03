package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class CharacterThumbnail(
    @SerializedName("path")
    var thumbnailPath: String,

    @SerializedName("extension")
    var thumbnailExtension: String
)