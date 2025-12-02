package com.example.codecraft

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.codecraft.databinding.FragmentCoursesBinding

class CoursesFragment : Fragment(R.layout.fragment_courses) {

    private var _binding: FragmentCoursesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCoursesBinding.bind(view)

        // Bottom Nav Clicks
        binding.navHome.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, DashboardFragment())
                .commit()
        }

        binding.navCourses.setOnClickListener {
            // Already on Courses
        }

        binding.navFavorites.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FavoritesFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.navProfile.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }

        // Example: dynamic course data
        binding.courseTitle1.text = "Kotlin for Beginners"
        binding.courseDesc1.text = "Learn Kotlin basics step by step"
        binding.courseTitle2.text = "Advanced Android"
        binding.courseDesc2.text = "Deep dive into Jetpack Compose"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
