package com.example.genericrecycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GenericRecyclerAdapter<T>(
    private val layoutId: Int,
    private val bindView: (itemView: View, item: T) -> Unit,
) : RecyclerView.Adapter<GenericRecyclerAdapter.GenericRecyclerAdapterHolder<T>>() {
    private val items = mutableListOf<T>()

    class GenericRecyclerAdapterHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            item: T,
            bindView: (itemView: View, item: T) -> Unit,
        ) {
            bindView(itemView, item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericRecyclerAdapterHolder<T> {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return GenericRecyclerAdapterHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GenericRecyclerAdapterHolder<T>, position: Int) {
        val item = items[position]
        holder.bind(item, bindView)
    }

    fun updateItems(newItems: List<T>) {
        this.items.clear()
        this.items.addAll(newItems)
        notifyDataSetChanged()
    }

}