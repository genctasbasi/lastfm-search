package com.escmobile.lab.lastfmsearch.api.albums

import com.google.gson.annotations.SerializedName

class AlbumMatches(
    @SerializedName("albummatches")
    val albumList: AlbumList
)