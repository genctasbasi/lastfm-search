package com.escmobile.lab.lastfmsearch.managers

import android.content.Context
import com.escmobile.lab.lastfmsearch.R
import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult
import com.escmobile.lab.lastfmsearch.services.SearchApiService
import retrofit2.Call
import javax.inject.Inject

class SearchManagerImpl @Inject constructor(
    private val searchApiService: SearchApiService,
    context: Context
) : SearchManager {

    private val apiVersion = context.getString(R.string.search_api_version)
    private val apiKey = context.getString(R.string.api_key)

    private var albumSearchCall: Call<AlbumSearchResult>? = null
    private var trackSearchCall: Call<TrackSearchResult>? = null
    private var artistSearchCall: Call<ArtistSearchResult>? = null

    override suspend fun searchAlbum(searchText: String): AlbumSearchResult? {
        albumSearchCall?.cancel()
        albumSearchCall = searchApiService.searchAlbum(apiVersion, apiKey, searchText)
        return albumSearchCall?.execute()?.body()
    }

    override suspend fun searchTrack(searchText: String): TrackSearchResult? {
        trackSearchCall?.cancel()
        trackSearchCall = searchApiService.searchTrack(apiVersion, apiKey, searchText)
        return trackSearchCall?.execute()?.body()
    }

    override suspend fun searchArtist(searchText: String): ArtistSearchResult? {
        artistSearchCall?.cancel()
        artistSearchCall = searchApiService.searchArtist(apiVersion, apiKey, searchText)
        return artistSearchCall?.execute()?.body()
    }
}