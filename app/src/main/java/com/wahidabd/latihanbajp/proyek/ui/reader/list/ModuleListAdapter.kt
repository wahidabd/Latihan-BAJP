package com.wahidabd.latihanbajp.proyek.ui.reader.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahidabd.latihanbajp.databinding.ItemsModuleListCustomBinding
import com.wahidabd.latihanbajp.proyek.data.ModuleEntity

class ModuleListAdapter internal constructor(private val listener: MyAdapterClickListener) : RecyclerView.Adapter<ModuleListAdapter.ViewHolder>(){

    private var listModules = ArrayList<ModuleEntity>()

    fun setModules(data: List<ModuleEntity>){
        listModules.clear()
        listModules.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleListAdapter.ViewHolder {
        val binding = ItemsModuleListCustomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModuleListAdapter.ViewHolder, position: Int) {
        holder.bind(listModules[position])

        holder.itemView.setOnClickListener {
            listener.onItemClicked(holder.adapterPosition, listModules[holder.adapterPosition].moduleId)
        }
    }

    override fun getItemCount(): Int = listModules.size

    inner class ViewHolder(private val binding: ItemsModuleListCustomBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ModuleEntity){
            binding.textModuleTitle.text = data.title
        }

    }
}

internal interface MyAdapterClickListener {
    fun onItemClicked(position: Int, moduleId: String)
}