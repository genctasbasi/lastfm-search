package com.escmobile.lab.lastfmsearch.adapters

interface ListItem {

    enum class Type {
        RESULT,
        HEADER,
    }

    fun getListItemType(): Type
}