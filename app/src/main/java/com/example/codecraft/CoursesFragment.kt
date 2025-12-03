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

        // Use requireActivity().supportFragmentManager to perform transactions
        val fragmentManager = requireActivity().supportFragmentManager

        // Bottom Nav Clicks
        binding.navHome.setOnClickListener {
            fragmentManager.beginTransaction()
                // The container ID from the Activity's layout is used here
                .replace(R.id.fragment_container, DashboardFragment())
                .commit()
        }

        binding.navCourses.setOnClickListener {
            // Already on Courses, no action needed
        }

        binding.navFavorites.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritesFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.navProfile.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
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
