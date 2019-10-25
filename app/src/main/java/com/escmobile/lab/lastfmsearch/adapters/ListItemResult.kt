package com.escmobile.lab.lastfmsearch.adapters

import com.escmobile.lab.lastfmsearch.api.CommonSearchResult

open class ListItemResult(
    val searchResult: CommonSearchResult
) : ListItem {

    override fun getListItemType(): ListItem.Type {
        return ListItem.Type.RESULT
    }

}