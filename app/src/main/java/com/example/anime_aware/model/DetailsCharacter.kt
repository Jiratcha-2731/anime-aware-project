package com.example.anime_aware.model

import com.google.gson.annotations.SerializedName

data class DetailsCharacter (
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("about")
    val about: String? = null,
)