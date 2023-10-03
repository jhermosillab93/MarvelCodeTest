package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class CharactersMainResponse(

    @SerializedName("code")
    var code : Int? = null,

    @SerializedName("status")
    var status : String? = null,

    @SerializedName("copyright")
    var copyright : String? = null,

    @SerializedName("attributionText")
    var attributionText : String? = null,

    @SerializedName("attributionHTML")
    var attributionHTML : String? = null,

    @SerializedName("data")
    var charactersData : CharactersListResponse?,

    @SerializedName("etag")
    var etag : String? = null
)