package com.escmobile.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

class Album(
    val mbid: String,
    val name: String,
    val artist: String,
    val url: String?,

    @SerializedName("image")
    val images: List<Image>?
)