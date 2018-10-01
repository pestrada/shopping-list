package org.pestrada.shoppinglist.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_item.view.*
import org.pestrada.shoppinglist.R
import org.pestrada.shoppinglist.models.ShoppingList

class ListsAdapter(private var lists: List<ShoppingList>) : RecyclerView.Adapter<ListsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = lists.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = lists[position]
        holder.contentView.text = list.timeStamp()
    }

    fun setData(shoppingLists: List<ShoppingList>) {
        lists = shoppingLists
        notifyDataSetChanged()
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val contentView: TextView = view.content
    }
}