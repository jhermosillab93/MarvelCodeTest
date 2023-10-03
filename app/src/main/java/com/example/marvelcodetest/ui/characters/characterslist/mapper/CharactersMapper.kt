package com.example.marvelcodetest.ui.characters.characterslist.mapper

import com.example.marvelcodetest.domain.model.CharacterDetails
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterListInfoUI

object CharactersMapper {
    fun mapFrom(input: CharacterDetails): CharacterListInfoUI {
        return CharacterListInfoUI(
            input.id,
            input.name,
            input.image
        )
    }
}