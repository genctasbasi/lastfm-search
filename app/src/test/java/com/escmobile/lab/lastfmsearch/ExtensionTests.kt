package com.escmobile.lab.lastfmsearch

import com.escmobile.lab.lastfmsearch.api.albums.AlbumList
import com.escmobile.lab.lastfmsearch.api.albums.AlbumMatches
import com.escmobile.lab.lastfmsearch.api.albums.AlbumSearchResult
import com.escmobile.lab.lastfmsearch.api.artists.ArtistList
import com.escmobile.lab.lastfmsearch.api.artists.ArtistMatches
import com.escmobile.lab.lastfmsearch.api.artists.ArtistSearchResult
import com.escmobile.lab.lastfmsearch.api.tracks.TrackList
import com.escmobile.lab.lastfmsearch.api.tracks.TrackMatches
import com.escmobile.lab.lastfmsearch.api.tracks.TrackSearchResult
import com.escmobile.lab.lastfmsearch.extensions.toCommonSearchResult
import com.escmobile.lab.lastfmsearch.model.Album
import com.escmobile.lab.lastfmsearch.model.Artist
import com.escmobile.lab.lastfmsearch.model.Track
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ExtensionTests {

    @Before
    fun setupTest() {
    }

    @Test
    fun albumSearchResultExtension() {

        // Arrange
        val albumSearchResult = AlbumSearchResult(
            AlbumMatches(
                AlbumList(
                    listOf(
                        Album(
                            "id",
                            "name",
                            "artist",
                            null,
                            null
                        )
                    )
                )
            )
        )

        val commonSearchResult = albumSearchResult.toCommonSearchResult()

        assertTrue(commonSearchResult != null)
        assertTrue(commonSearchResult!!.isNotEmpty())
    }

    @Test
    fun trackSearchResultExtension() {

        // Arrange
        val trackSearchResult = TrackSearchResult(
            TrackMatches(
                TrackList(
                    listOf(
                        Track(
                            "name",
                            "artist",
                            "url",
                            0,
                            "id",
                            null
                        )
                    )
                )
            )
        )

        val commonSearchResult = trackSearchResult.toCommonSearchResult()

        assertTrue(commonSearchResult != null)
        assertTrue(commonSearchResult!!.isNotEmpty())
    }

    @Test
    fun artistSearchResultExtension() {

        // Arrange
        val artistSearchResult = ArtistSearchResult(
            ArtistMatches(
                ArtistList(
                    listOf(
                        Artist(
                            "id",
                            "name",
                            0,
                            "",
                            null
                        )
                    )
                )
            )
        )

        val commonSearchResult = artistSearchResult.toCommonSearchResult()

        assertTrue(commonSearchResult != null)
        assertTrue(commonSearchResult!!.isNotEmpty())
    }
}
