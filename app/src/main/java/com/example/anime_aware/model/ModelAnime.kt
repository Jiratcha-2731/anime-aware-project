package com.example.anime_aware.model

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.RelatedAnime
import moe.ganen.jikankt.models.base.types.TimeInterval
import moe.ganen.jikankt.models.search.enums.AnimeType

data class ModelAnime(
    @SerializedName("request_hash")
    val requestHash: String? = null,
    @SerializedName("request_cached")
    val requestCached: Boolean? = null,
    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("trailer_url")
    val trailerUrl: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("title_english")
    val titleEnglish: String? = null,
    @SerializedName("title_japanese")
    val titleJapanese: String? = null,
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String?>? = null,
    @SerializedName("type")
    val type: AnimeType? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("episodes")
    val episodes: Int? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("airing")
    val airing: Boolean? = null,
    @SerializedName("aired")
    val aired: TimeInterval? = null,
    @SerializedName("duration")
    val duration: String? = null,
    @SerializedName("rating")
    val rating: String? = null,
    @SerializedName("score")
    val score: Double? = null,
    @SerializedName("scored_by")
    val scoredBy: Int? = null,
    @SerializedName("rank")
    val rank: Int? = null,
    @SerializedName("popularity")
    val popularity: Int? = null,
    @SerializedName("members")
    val members: Int? = null,
    @SerializedName("favorites")
    val favorites: Int? = null,
    @SerializedName("synopsis")
    val synopsis: String? = null,
    @SerializedName("background")
    val background: String? = null,
    @SerializedName("premiered")
    val premiered: String? = null,
    @SerializedName("broadcast")
    val broadcast: String? = null,
    @SerializedName("related")
    val related: RelatedAnime? = null,
    @SerializedName("producers")
    val producers: List<MalSubEntity?>? = null,
    @SerializedName("licensors")
    val licensors: List<MalSubEntity?>? = null,
    @SerializedName("studios")
    val studios: List<MalSubEntity?>? = null,
    @SerializedName("genres")
    val genres: List<MalSubEntity?>? = null,
    @SerializedName("opening_themes")
    val openingThemes: List<String?>? = null,
    @SerializedName("ending_themes")
    val endingThemes: List<String?>? = null
)

