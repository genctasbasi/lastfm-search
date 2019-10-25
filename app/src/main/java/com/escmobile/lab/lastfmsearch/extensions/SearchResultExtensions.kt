package com.escmobile.lab.lastfmsearch.extensions

import com.escmobile.lab.lastfmsearch.adapters.ListItem
import com.escmobile.lab.lastfmsearch.adapters.ListItemResult
import com.escmobile.lab.lastfmsearch.api.CommonSearchResult
import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult
import com.escmobile.lab.lastfmsearch.model.*

fun AlbumSearchResult?.toCommonSearchResult(): List<CommonSearchResult>? {
    return this?.results?.albumList?.albums?.map { it.toCommonSearchResult() }
}

fun TrackSearchResult?.toCommonSearchResult(): List<CommonSearchResult>? {
    return this?.results?.trackList?.tracks?.map { it.toCommonSearchResult() }
}

fun ArtistSearchResult?.toCommonSearchResult(): List<CommonSearchResult>? {
    return this?.results?.artistList?.artists?.map { it.toCommonSearchResult() }
}

fun List<CommonSearchResult>.toListItem(): List<ListItem> {
    return this.map { it.toListItem() }
}

private fun CommonSearchResult.toListItem(): ListItem {
    return ListItemResult(this)
}

private fun Album.toCommonSearchResult(): CommonSearchResult {

    return CommonSearchResult(
        SearchResultType.Album,
        this.mbid,
        this.name,
        "Artist: ${this.artist}",
        this.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Medium }?.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Large }?.url
    )
}

private fun Track.toCommonSearchResult(): CommonSearchResult {
    return CommonSearchResult(
        SearchResultType.Track,
        this.mbid,
        this.name,
        "Artist: ${this.artist}",
        this.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Medium }?.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Large }?.url
    )
}

private fun Artist.toCommonSearchResult(): CommonSearchResult {
    return CommonSearchResult(
        SearchResultType.Artist,
        this.mbid,
        this.name,
        "Listeners: ${this.listeners}",
        this.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Medium }?.url,
        this.images?.firstOrNull { it.imageSize == ImageSize.Large }?.url
    )
}

