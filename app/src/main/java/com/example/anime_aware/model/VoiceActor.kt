package com.example.anime_aware.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class VoiceActor(
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("language")
    val language: String? = null
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(language)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VoiceActor> {
        override fun createFromParcel(parcel: Parcel): VoiceActor {
            return VoiceActor(parcel)
        }

        override fun newArray(size: Int): Array<VoiceActor?> {
            return arrayOfNulls(size)
        }
    }

}