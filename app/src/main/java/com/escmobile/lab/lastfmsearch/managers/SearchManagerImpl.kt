package com.escmobile.lab.lastfmsearch.managers

import android.content.Context
import com.escmobile.lab.lastfmsearch.R
import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult
import com.escmobile.lab.lastfmsearch.services.SearchApiService
import retrofit2.Call
import timber.log.Timber
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
        return try {
            albumSearchCall?.execute()?.body()
        } catch (e: Exception) {
            // TODO handle this better - indicate a network error if there is one
            Timber.e(e, "Call to album search failed for $searchText")
            null
        }
    }

    override suspend fun searchTrack(searchText: String): TrackSearchResult? {
        trackSearchCall?.cancel()
        trackSearchCall = searchApiService.searchTrack(apiVersion, apiKey, searchText)
        return try {
            trackSearchCall?.execute()?.body()
        } catch (e: Exception) {
            // TODO handle this better - indicate a network error if there is one
            Timber.e(e, "Call to track search failed for $searchText")
            null
        }
    }

    override suspend fun searchArtist(searchText: String): ArtistSearchResult? {
        artistSearchCall?.cancel()
        artistSearchCall = searchApiService.searchArtist(apiVersion, apiKey, searchText)
        return try {
            artistSearchCall?.execute()?.body()
        } catch (e: Exception) {
            // TODO handle this better - indicate a network error if there is one
            Timber.e(e, "Call to artist search failed for $searchText")
            null
        }
    }
}