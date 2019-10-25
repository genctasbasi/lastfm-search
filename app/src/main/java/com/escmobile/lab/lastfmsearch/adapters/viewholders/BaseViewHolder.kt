package com.escmobile.lab.lastfmsearch.adapters.viewholders

import android.content.Context
import com.escmobile.lab.lastfmsearch.adapters.ListClickListener

interface BaseViewHolder<V, D> {
    fun bindViews(context: Context, data: D, listener: ListClickListener<V, D>, position: Int)
}