package com.example.marvelcodetest.ui.characters.characterslist

import androidx.lifecycle.AndroidViewModel
import com.example.marvelcodetest.core.MainApplication
import com.example.marvelcodetest.domain.model.Resource
import com.example.marvelcodetest.domain.usecase.GetCharacterDetailUseCase
import com.example.marvelcodetest.domain.usecase.GetCharactersListUseCase
import com.example.marvelcodetest.ui.base.SingleLiveEvent
import com.example.marvelcodetest.ui.characters.characterslist.mapper.CharacterDetailMapper
import com.example.marvelcodetest.ui.characters.characterslist.mapper.CharactersMapper
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterDetailUI
import com.example.marvelcodetest.ui.characters.characterslist.model.CharacterListInfoUI
import javax.inject.Inject

class CharactersListViewModel @Inject constructor(
    private val application: MainApplication,
    private val getCharactersListUseCase: GetCharactersListUseCase,
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase
) : AndroidViewModel(application) {

    val characters: SingleLiveEvent<Resource<List<CharacterListInfoUI>>> = SingleLiveEvent()
    val characterDetails: SingleLiveEvent<Resource<CharacterDetailUI>> = SingleLiveEvent()

    fun onStart() {
        getCharacters()
    }

    private fun getCharacters() {
        characters.postValue(Resource.Loading())
        getCharactersListUseCase.executeAsync(
            onSuccess = { m ->
                val charactersList = m.map { CharactersMapper.mapFrom(it) }
                characters.postValue(Resource.Success(charactersList))
            }, {
                characters.postValue(Resource.Error(it, null))
            })
    }

    fun onCharacterClick(characterUI: CharacterListInfoUI) {
        characterDetails.postValue(Resource.Loading())
        getCharacterDetailUseCase.executeAsync(characterId = characterUI.id,
            onSuccess = { m ->
                val characterInfo = CharacterDetailMapper.mapFrom(application, m)
                characterDetails.postValue(Resource.Success(characterInfo))
            }, onError = {
                characterDetails.postValue(Resource.Error(it, null))
            })

    }

}