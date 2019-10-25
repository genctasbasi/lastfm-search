package com.escmobile.lab.lastfmsearch.services

import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApiService {

    @POST("/{api_version}/?method=album.search&format=json")
    fun searchAlbum(
        @Path("api_version") version: String,
        @Query("api_key") apiKey: String,
        @Query("album") searchText: String
    ): Call<AlbumSearchResult>

    @POST("/{api_version}/?method=track.search&format=json")
    fun searchTrack(
        @Path("api_version") version: String,
        @Query("api_key") apiKey: String,
        @Query("track") searchText: String
    ): Call<TrackSearchResult>

    @GET("/{api_version}/?method=artist.search&format=json")
    fun searchArtist(
        @Path("api_version") version: String,
        @Query("api_key") apiKey: String,
        @Query("artist") searchText: String
    ): Call<ArtistSearchResult>

}