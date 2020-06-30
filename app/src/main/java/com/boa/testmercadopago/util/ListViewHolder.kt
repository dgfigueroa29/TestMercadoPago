package com.boa.testmercadopago.util

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemListRoot: ConstraintLayout = view.itemListRoot
    val itemListText: TextView = view.itemListText
}