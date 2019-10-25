package com.escmobile.lab.lastfmsearch.adapters

interface ListClickListener<V, D> {
    fun onRowTap(view: V, data: D)
}