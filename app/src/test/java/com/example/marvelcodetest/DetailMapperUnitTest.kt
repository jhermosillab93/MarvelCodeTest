package com.example.marvelcodetest

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.marvelbusinessapi.client.model.CharacterInfo
import com.example.marvelbusinessapi.client.model.CharacterThumbnail
import com.example.marvelcodetest.domain.data.mapper.CharacterDetailsMapper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class DetailMapperUnitTest {

    @Test
    fun test_character_detail_mapper() {
        val characterDetails = Mockito.mock(CharacterInfo::class.java)
        Mockito.`when`(characterDetails.characterThumbnail).thenReturn(CharacterThumbnail("PictureURL", "jpg"))
        Assert.assertTrue(CharacterDetailsMapper.getImageUrl(characterDetails.characterThumbnail.thumbnailPath, characterDetails.characterThumbnail.thumbnailExtension) == "PictureURL.jpg")
    }
}