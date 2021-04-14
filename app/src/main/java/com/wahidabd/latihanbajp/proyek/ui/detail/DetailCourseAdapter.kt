package com.wahidabd.latihanbajp.proyek.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wahidabd.latihanbajp.databinding.ItemsModuleListBinding
import com.wahidabd.latihanbajp.proyek.data.ModuleEntity

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ViewHolder>() {

    private var courseList = ArrayList<ModuleEntity>()

    fun setCourse(data: List<ModuleEntity>){
        courseList.clear()
        courseList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(courseList[position])
    }

    override fun getItemCount(): Int = courseList.size


    inner class ViewHolder(private val binding: ItemsModuleListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: ModuleEntity){
            binding.textModuleTitle.text = data.title
        }
    }
}