package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

class StorieInfo(

    @SerializedName("resourceURI")
    var resourceURI: Int,

    @SerializedName("name")
    var name: Int,

    @SerializedName("type")
    var type: String
)