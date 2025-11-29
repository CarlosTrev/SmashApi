package com.example.smashapi.data
import com.example.smashapi.data.SmashCharacter
import retrofit2.http.GET

interface ApiService {

    @GET("ultimate/characters")
    suspend fun getCharacters(): List<SmashCharacter>
}

