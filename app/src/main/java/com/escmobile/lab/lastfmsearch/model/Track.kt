package com.escmobile.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

class Track(
    val name: String,
    val artist: String,
    val url: String,
    val listeners: Int,
    val mbid: String,

    @SerializedName("image")
    val images: List<Image>?
)