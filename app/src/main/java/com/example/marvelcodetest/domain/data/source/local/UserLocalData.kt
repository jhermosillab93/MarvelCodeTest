package com.example.marvelcodetest.domain.data.source.local

import com.example.marvelcodetest.domain.model.CharacterDetails
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalData @Inject constructor() {

    val characterDetails: MutableList<CharacterDetails> = mutableListOf()

}