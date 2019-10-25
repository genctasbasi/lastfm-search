package com.escmobile.lab.lastfmsearch.api.tracks

import com.escmobile.lab.lastfmsearch.model.Track
import com.google.gson.annotations.SerializedName

class TrackList(
    @SerializedName("track")
    val tracks: List<Track>
)