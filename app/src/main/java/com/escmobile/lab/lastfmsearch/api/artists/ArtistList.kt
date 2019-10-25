package com.escmobile.lab.lastfmsearch.api.artists

import com.escmobile.lab.lastfmsearch.model.Artist
import com.google.gson.annotations.SerializedName

class ArtistList(
    @SerializedName("artist")
    val artists: List<Artist>
)