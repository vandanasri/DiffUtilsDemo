package com.vandana.diffutilrecyclerviewdemoapp

import androidx.recyclerview.widget.DiffUtil


//DiffUtil is a utility class that can calculate the difference between two lists and
// output a list of update operations that converts the first list into the second one.

//It can be used to calculate updates for a RecyclerView Adapter.

open class MyDiffCallback(
    private val oldSports: List<String>,
    private val newSports: List<String>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldSports.size
    }

    override fun getNewListSize(): Int {
        return newSports.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // In the real world you need to compare something unique like id
        return oldSports[oldItemPosition] == newSports[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        // This is called if areItemsTheSame() == true;
        return oldSports[oldItemPosition] == newSports[newItemPosition]
    }
}
//end