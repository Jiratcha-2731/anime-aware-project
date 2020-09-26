package com.example.anime_aware.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Characters(
//    detail
    @SerializedName("mal_id")
    val malId: Int,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("role")
    val role: String? = null,
    val voiceActors: List<VoiceActor>?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArrayList(VoiceActor)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(malId)
        parcel.writeString(url)
        parcel.writeString(imageUrl)
        parcel.writeString(name)
        parcel.writeString(role)
        parcel.writeTypedList(voiceActors)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Characters> {
        override fun createFromParcel(parcel: Parcel): Characters {
            return Characters(parcel)
        }

        override fun newArray(size: Int): Array<Characters?> {
            return arrayOfNulls(size)
        }
    }

}
