package com.example.anime_aware.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class base(
    //    head
    @SerializedName("request_hash")
    val requestHash: String? = null,
    @SerializedName("request_cached")
    val requestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,
    @SerializedName("characters")
    val characters: ArrayList<Characters>? = null
)