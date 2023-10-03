package com.example.marvelcodetest.domain.repository

import com.example.marvelcodetest.domain.model.CharacterDetails

interface MarvelRepository {
    fun fetchCharactersList(onSuccess: (List<CharacterDetails>) -> Unit,
                            onError: (Throwable) -> Unit)

    fun getCharacterById(characterId: String): CharacterDetails?

    fun saveCharactersList(characters: List<CharacterDetails>)
    //fun deleteCharactersList()
}