package com.example.codecraft.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codecraft.databinding.ItemCourseBinding
import com.example.codecraft.models.CourseModel

class CourseAdapter(
    private val courseList: List<CourseModel>
) : RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    inner class CourseViewHolder(val binding: ItemCourseBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemCourseBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]

        holder.binding.apply {
            courseTitle.text = course.title
            courseDuration.text = course.duration
            courseRating.text = course.rating.toString()
            courseReviews.text = "${course.reviews} Reviews"
            courseImage.setImageResource(course.image)
        }
    }

    override fun getItemCount(): Int = courseList.size
}