package com.example.genericrecycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding



class RecAdapter<T,VB:ViewBinding>(
    private val layoutId: Int,
    private val bindView: (binding: VB, item: T) -> Unit,
    private val bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> VB
) : RecyclerView.Adapter<RecAdapter.RecAdapterHolder<T,VB>>() {

    private val items = mutableListOf<T>()

    class RecAdapterHolder<T,VB:ViewBinding>(private val binding:VB) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T, bindView: (bindingView: VB, item: T) -> Unit) {
            bindView(binding, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecAdapterHolder<T,VB> {
        val binding = bindingInflater(LayoutInflater.from(parent.context),parent,false)
        return RecAdapterHolder(binding)
    }

    override fun onBindViewHolder(holder: RecAdapterHolder<T,VB>, position: Int) {
        val item = items[position]
        holder.bind(item, bindView)
    }

    override fun getItemCount(): Int = items.size

    fun updateItems(newItems: List<T>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}
