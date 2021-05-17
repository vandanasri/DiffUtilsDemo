package com.vandana.diffutilrecyclerviewdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

/**
 * This class will generate the recycled views and load data when they come into screen using
 * view holder pattern. Updates from the data source to the recyclerview will occur through
 * notifyDatasetChanged
 */
class MyNotifyDataSetAdapter(var places: List<String>):
         RecyclerView.Adapter<MyNotifyDataSetAdapter.MyViewHolder>() {

    var ItemClickListener: ((position: Int, name: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewHolderType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        // Size of items to load
        return places.size
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bindView(places[position], position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(places: String, position: Int) {
            itemView.itemText.text = places

            itemView.setOnClickListener {
                ItemClickListener?.invoke(position, places)
            }
        }
    }
    fun updateList(newStars: List<String>) {
        this.places = newStars

        // Call this when you change the data of Recycler View to refresh the items
        notifyDataSetChanged()
    }
}
