package com.example.marvelcodetest.domain.data.mapper

import com.example.marvelbusinessapi.BuildConfig
import com.example.marvelbusinessapi.client.model.CharacterInfo
import com.example.marvelcodetest.domain.model.CharacterDetails

object CharacterDetailsMapper {

    fun mapFrom(
        input: CharacterInfo,
    ): CharacterDetails {
        return CharacterDetails(
            id = input.characterId,
            name = input.characterName,
            image = getImageUrl(input.characterThumbnail.thumbnailPath, input.characterThumbnail.thumbnailExtension),
            description = input.characterDescription,
            comicsNumber = input.comics.available ?: 0,
            seriesNumber = input.series.available ?: 0,
            comicURL = input.urls.find { it.type == "comiclink" }?.url.toString()
        )
    }

    fun getImageUrl(thumbnailPath: String, thumbnailExtension: String): String {
        return if(!BuildConfig.IS_DEMO){
            "$thumbnailPath/landscape_xlarge.$thumbnailExtension"
        } else "$thumbnailPath.$thumbnailExtension"
    }
}