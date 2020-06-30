package com.boa.testmercadopago.util

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewGroupCompat
import androidx.recyclerview.widget.RecyclerView
import com.boa.domain.model.CardIssuer
import com.boa.domain.model.Installment
import com.boa.domain.model.PaymentMethod
import com.boa.testmercadopago.R
import com.boa.testmercadopago.base.OnSelectItem

class ListAdapter<T>(private val context: Context, private val onSelectItem: OnSelectItem<T>) :
    RecyclerView.Adapter<ListViewHolder>() {
    private var list = listOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_list,
            parent,
            false
        )
        ViewGroupCompat.setTransitionGroup(view as ViewGroup, true)
        val holder = ListViewHolder(view)

        holder.itemListRoot.setOnClickListener {
            onSelectItem.onSelectItem(list[holder.adapterPosition])
        }

        return holder
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        when (val item = list[position]) {
            is CardIssuer -> {
                holder.itemListText.text = item.name
            }

            is PaymentMethod -> {
                holder.itemListText.text = item.name
            }

            is Installment -> {
                holder.itemListText.text = item.message
            }
        }
    }

    fun setData(newList: List<T>) {
        list = newList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}