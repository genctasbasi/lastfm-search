package com.escmobile.lab.lastfmsearch.adapters

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.escmobile.lab.lastfmsearch.adapters.viewholders.BaseViewHolder
import kotlinx.android.synthetic.main.row_header.view.*

class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view),
    BaseViewHolder<View, ListItemHeader> {

    override fun bindViews(
        context: Context,
        data: ListItemHeader,
        listener: ListClickListener<View, ListItemHeader>,
        position: Int
    ) {
        header.text = data.header
    }

    private val header: TextView = view.header
}