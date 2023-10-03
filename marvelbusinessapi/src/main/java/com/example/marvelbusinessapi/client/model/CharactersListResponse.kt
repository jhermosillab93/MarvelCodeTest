package com.example.marvelbusinessapi.client.model

import com.google.gson.annotations.SerializedName

data class CharactersListResponse(

    @SerializedName("offset")
    var offset : Int? = null,

    @SerializedName("limit")
    var limit : Int? = null,

    @SerializedName("total")
    var total : Int? = null,

    @SerializedName("count")
    var count : Int? = null,

    @SerializedName("results")
    var charactersList : List<CharacterInfo>
)