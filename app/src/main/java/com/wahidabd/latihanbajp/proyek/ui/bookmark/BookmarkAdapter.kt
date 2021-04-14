package com.wahidabd.latihanbajp.proyek.ui.bookmark

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.wahidabd.latihanbajp.R
import com.wahidabd.latihanbajp.databinding.ItemsBookmarkBinding
import com.wahidabd.latihanbajp.proyek.data.CourseEntity
import com.wahidabd.latihanbajp.proyek.ui.detail.DetailCourseActivity

class BookmarkAdapter(private val callback: BookmarkCallback) : RecyclerView.Adapter<BookmarkAdapter.ViewHolder>() {

    private var listCourse = ArrayList<CourseEntity>()

    fun setCourse(data: List<CourseEntity>){
        listCourse.clear()
        listCourse.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsBookmarkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCourse[position])
    }

    override fun getItemCount(): Int = listCourse.size

    inner class ViewHolder(private val binding: ItemsBookmarkBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: CourseEntity){
            with(binding){
                tvItemTitle.text = data.title
                tvItemDate.text = itemView.resources.getString(R.string.deadline_date, data.deadline)

                binding.root.setOnClickListener {
                    val intent = Intent(itemView.context, DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURSE, data.courseId)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener{callback.onShareClick(data)}

                Glide.with(itemView.context)
                    .load(data.imagePath)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_error)
                    .into(imgPoster)
            }
        }
    }
}