package com.escmobile.lab.lastfmsearch.model

import com.google.gson.annotations.SerializedName

class Image(
    @SerializedName("#text")
    val url: String,

    @SerializedName("size")
    val imageSize: ImageSize
)