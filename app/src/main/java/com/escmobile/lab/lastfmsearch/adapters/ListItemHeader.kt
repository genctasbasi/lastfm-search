package com.escmobile.lab.lastfmsearch.adapters

open class ListItemHeader(val header: String) : ListItem {

    override fun getListItemType(): ListItem.Type {
        return ListItem.Type.HEADER
    }

}