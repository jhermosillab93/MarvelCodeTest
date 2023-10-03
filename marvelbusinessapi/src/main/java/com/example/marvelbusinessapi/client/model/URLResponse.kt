package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

class URLResponse(

    @SerializedName("type")
    var type: String,

    @SerializedName("url")
    var url: String
)