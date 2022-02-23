package com.lahsuak.apps.task1.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.lahsuak.apps.task1.model.Details
import com.lahsuak.apps.task1.databinding.DataItemBinding


class DataAdapter(private val context: Context, private val list: List<Details>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    class DataViewHolder(binding: DataItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding1 = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = DataItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data = list[position]
        holder.binding1.data = data
        holder.binding1.executePendingBindings()
    }

    override fun getItemCount() = list.size
}