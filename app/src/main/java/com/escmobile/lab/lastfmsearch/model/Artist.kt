package com.escmobile.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

class Artist(
    val mbid: String,
    val name: String,
    val listeners: Int,
    val url: String,

    @SerializedName("image")
    val images: List<Image>?
)