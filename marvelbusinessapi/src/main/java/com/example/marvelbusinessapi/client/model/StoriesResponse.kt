package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class StoriesResponse (

    @SerializedName("available")
    var available: Int,

    @SerializedName("returned")
    var returned: Int,

    @SerializedName("collectionURI")
    var collectionURI: String,

    @SerializedName("items")
    var storiesList: List<StorieInfo>
)