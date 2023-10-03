package com.example.marvelbusinessapi.custom.demo

import com.example.marvelbusinessapi.client.api.MarvelApi
import com.example.marvelbusinessapi.client.model.CharacterComicsResponse
import com.example.marvelbusinessapi.client.model.CharacterInfo
import com.example.marvelbusinessapi.client.model.CharacterThumbnail
import com.example.marvelbusinessapi.client.model.CharactersListResponse
import com.example.marvelbusinessapi.client.model.CharactersMainResponse
import com.example.marvelbusinessapi.client.model.URLResponse
import rx.Observable

class MarvelApiDemo: MarvelApi {


    override fun getCharacters(): Observable<CharactersMainResponse> {
        val tahneeURL = URLResponse("comiclink", "https://www.canyon.com/es-es/blog-content/noticias-ciclismo-profesional/rider-profile-tahnee-seagrave.html")
        val tahneeThumbnail = CharacterThumbnail("https://img.redbull.com/images/q_auto,f_auto/redbullcom/2017/01/11/1331839205258_3/tahn%C3%A9e-seagrave-en-su-hogar-en-llanfylli", "jpg")
        val genericMedia = CharacterComicsResponse(available = 123456)
        val tahnee = CharacterInfo(
            characterId = "001",
            characterName = "Tahnee Seagrave",
            characterDescription = "She is fast as hell",
            urls = listOf(tahneeURL),
            characterThumbnail = tahneeThumbnail,
            comics = genericMedia,
            stories = genericMedia,
            events = genericMedia,
            series = genericMedia
        )

        val thomasURL = URLResponse("comiclink", "https://www.canyon.com/es-es/blog-content/noticias-ciclismo-profesional/rider-profile-tomas-lemoine.html")
        val thomasThumbnail = CharacterThumbnail("https://www.velovert.com/photos/news/zooms/7f4b4da8e92b7a1586bfbeafb9d147b0161061947433", "jpg")
        val thomas = CharacterInfo(
            characterId = "002",
            characterName = "Thomas Lemoine",
            characterDescription = "A fellow man of culture who rides a Stitched 720",
            urls = listOf(thomasURL),
            characterThumbnail = thomasThumbnail,
            comics = genericMedia,
            stories = genericMedia,
            events = genericMedia,
            series = genericMedia
        )
        val characters = CharactersListResponse(charactersList = listOf(tahnee, thomas))
        val response = CharactersMainResponse(charactersData = characters)
        return Observable.just(response)
    }
}