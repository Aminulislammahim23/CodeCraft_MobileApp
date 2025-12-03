package com.example.codecraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codecraft.CoursesFragment
import com.example.codecraft.DashboardFragment
import com.example.codecraft.ProfileFragment
import com.example.codecraft.databinding.FragmentFavoritesBinding

data class Course(
    val id: String,
    val title: String,
    val description: String,
    val imageResId: Int,
    val progress: Int,
    val isFavorite: Boolean = true
)

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBottomNavigation()
        setupCourseCards()
    }

    private fun setupBottomNavigation() {
        // Set click listeners for bottom navigation items
        binding.navHome.setOnClickListener {
            // Navigate to HomeFragment
            navigateToHome()
        }

        binding.navCourses.setOnClickListener {
            // Navigate to CoursesFragment
            navigateToCourses()
        }

        binding.navFavorites.setOnClickListener {
            // Already in Favorites, do nothing or refresh
            refreshFavorites()
        }

        binding.navProfile.setOnClickListener {
            // Navigate to ProfileFragment
            navigateToProfile()
        }
    }

    private fun setupCourseCards() {
        // Setup click listeners for course cards
        binding.favCourseCard1.setOnClickListener {
            // Open course details for Kotlin Basics
            openCourseDetails("course1")
        }

        binding.favCourseCard2.setOnClickListener {
            // Open course details for Advanced Android
            openCourseDetails("course2")
        }

        // Update course data programmatically if needed
        updateCourseProgress()
    }

    private fun navigateToHome() {
        // Replace with your navigation logic
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, DashboardFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToCourses() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CoursesFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun navigateToProfile() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun refreshFavorites() {

    }

    private fun openCourseDetails(courseId: String) {
        // Navigate to course details fragment
        val fragment = CourseDetailsFragment.newInstance(courseId)
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("favorites")
            .commit()
    }

    private fun updateCourseProgress() {

        binding.favCourseProgress1.progress = 50
        binding.favCourseProgress2.progress = 80
    }

    fun updateCourses(courses: List<Course>) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}