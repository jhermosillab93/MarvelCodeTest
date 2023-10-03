package com.example.marvelcodetest.domain.data.repository

import com.example.marvelbusinessapi.custom.MarvelBusinessApi
import com.example.marvelbusinessapi.custom.request.CharactersListRequest
import com.example.marvelcodetest.domain.data.mapper.CharacterDetailsMapper
import com.example.marvelcodetest.domain.data.source.local.UserLocalData
import com.example.marvelcodetest.domain.model.CharacterDetails
import com.example.marvelcodetest.domain.repository.MarvelRepository
import javax.inject.Inject

class MarvelDataRepository @Inject constructor(private val userLocalData: UserLocalData,
                                               private var marvelBusinessApi: MarvelBusinessApi
): MarvelRepository {

    override fun fetchCharactersList(
        onSuccess: (List<CharacterDetails>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        marvelBusinessApi.getCharactersList().setParameters(
                CharactersListRequest.MyParameters()
        ).call().subscribe({ charactersResponse ->
            val charactersList: MutableList<CharacterDetails> = mutableListOf()
            charactersList.addAll(charactersResponse.charactersData?.charactersList!!.map {
                CharacterDetailsMapper.mapFrom(it)
            })
            saveCharactersList(charactersList)
            onSuccess(charactersList)
            }, {
                onError(it)
            })
        }

    override fun getCharacterById(characterId: String): CharacterDetails? {
        return userLocalData.characterDetails.find { it.id == characterId }
    }

    override fun saveCharactersList(characters: List<CharacterDetails>) {
        userLocalData.characterDetails.clear()
        userLocalData.characterDetails.addAll(characters)
    }

    /*
    //Fun used for clearing characters list from local data. It could be used if we wanted to do a logout or reset app operation
    override fun deleteCharactersList() {
        userLocalData.characterDetails.clear()
    }*/
}