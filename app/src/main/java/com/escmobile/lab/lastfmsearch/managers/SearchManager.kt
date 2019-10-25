package com.escmobile.lab.lastfmsearch.managers

import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult

interface SearchManager {
    suspend fun searchAlbum(searchText: String): AlbumSearchResult?
    suspend fun searchTrack(searchText: String): TrackSearchResult?
    suspend fun searchArtist(searchText: String): ArtistSearchResult?
}