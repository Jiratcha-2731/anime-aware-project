package com.example.anime_aware.data

import com.example.anime_aware.model.Characters
import com.example.anime_aware.model.DetailsCharacter
import com.example.anime_aware.model.base
import retrofit2.Call
import retrofit2.http.*
import java.util.ArrayList


interface ApiClient {

    @GET("anime/1/characters_staff")
    fun getAnimeCharacterList(): Call<base>

    @GET("character/{id}")
    fun getAnimeDetail(@Path("id") id: Int?): Call<DetailsCharacter>

}
