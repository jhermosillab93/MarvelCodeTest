package com.example.marvelcodetest.ui.characters.characterslist.mapper

import android.content.Context
import com.example.marvelcodetest.R
import com.example.marvelcodetest.domain.model.CharacterDetails
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterDetailUI

object CharacterDetailMapper {
    fun mapFrom(context: Context, input: CharacterDetails): CharacterDetailUI {
        return CharacterDetailUI(
            name = input.name,
            imageResource = input.image,
            description = input.description.ifEmpty { context.getString(R.string.description_not_available) },
            numberOfComics = input.comicsNumber.toString(),
            numberOfSeries = input.seriesNumber.toString(),
            linkToComics = input.comicURL
        )
    }
}