package com.escmobile.lab.lastfmsearch.api.tracks

import com.google.gson.annotations.SerializedName

class TrackMatches(
    @SerializedName("trackmatches")
    val trackList: TrackList
)