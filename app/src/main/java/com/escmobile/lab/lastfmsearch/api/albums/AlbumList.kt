package com.escmobile.lab.lastfmsearch.api.albums

import com.escmobile.lab.lastfmsearch.model.Album
import com.google.gson.annotations.SerializedName

class AlbumList(
    @SerializedName("album")
    val albums: List<Album>
)