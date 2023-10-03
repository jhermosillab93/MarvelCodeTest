package com.example.marvelcodetest.domain.usecase

import com.example.marvelcodetest.domain.model.CharacterDetails
import com.example.marvelcodetest.domain.repository.MarvelRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(private val marvelRepository: MarvelRepository) {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun executeAsync(
        characterId: String,
        onSuccess: (CharacterDetails) -> Unit,
        onError: (Throwable) -> Unit
    ) {

        scope.launch {
            marvelRepository.getCharacterById(characterId)?.let {
                onSuccess(it)
            } ?: onError(Throwable())
        }
    }

}