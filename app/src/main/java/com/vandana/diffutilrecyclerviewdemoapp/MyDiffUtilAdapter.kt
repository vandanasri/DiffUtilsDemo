package com.vandana.diffutilrecyclerviewdemoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_recyclerview.view.*

/**
 * This is the same RecyclerView but using DiffUtil instead of
 * notifyDataSetChanged() to animate changes
 */
class MyDiffUtilAdapter(private var sports: List<String>):
         RecyclerView.Adapter<MyDiffUtilAdapter.MyViewHolder>() {

    var itemClickListener: ((position: Int, name: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewHolderType: Int):
     MyViewHolder = MyViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.item_recyclerview, parent, false))

    override fun getItemCount(): Int = sports.size

    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        viewHolder.bindView(sports[position], position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(sports: String, position: Int) {
            itemView.itemText.text = sports
            itemView.setOnClickListener { itemClickListener?.invoke(position, sports) }
        }
    }

    /**
     *  THIS IS THE ONLY DIFFERENCE BETWEEN the regular MyNotifyDataSetAdapter
     */
    fun updateList(newSports: List<String>) {

        val diffCallback = MyDiffCallback(this.sports, newSports)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)

        this.sports = newSports
    }
}
//end

