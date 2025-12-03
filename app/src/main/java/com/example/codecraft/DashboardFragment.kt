package com.example.codecraft

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.codecraft.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDashboardBinding.bind(view)

        // ---- Set Stat Card Values ----
        binding.cardCompleted.tvValue.text = "0"
        binding.cardCompleted.tvLabel.text = "Completed"

        binding.cardProgress.tvValue.text = "0"
        binding.cardProgress.tvLabel.text = "In Progress"

        binding.cardTotal.tvValue.text = "8"
        binding.cardTotal.tvLabel.text = "Total"

        // ---- Tab Click Actions ----
        binding.btnAll.setOnClickListener { highlightTab(it) }
        binding.btnBeginner.setOnClickListener { highlightTab(it) }
        binding.btnIntermediate.setOnClickListener { highlightTab(it) }
        binding.btnAdvanced.setOnClickListener { highlightTab(it) }

        // ---- Bottom Navigation Clicks ----
        binding.navHome.setOnClickListener {
            // Already on Dashboard/Home, maybe scroll to top
            binding.dashboardScroll.smoothScrollTo(0, 0)
        }

        binding.navCourses.setOnClickListener {
            // CORRECTED: Use the actual container ID from your Activity's layout
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CoursesFragment()) // Use the container ID
                .addToBackStack(null)
                .commit()
        }

        binding.navFavorites.setOnClickListener {
            // CORRECTED: Use the actual container ID from your Activity's layout
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritesFragment()) // Use the container ID
                .addToBackStack(null)
                .commit()
        }

        binding.navProfile.setOnClickListener {
            // CORRECTED: Use the actual container ID from your Activity's layout
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment()) // Use the container ID
                .addToBackStack(null)
                .commit()
        }
    }

    // ---- Tab Highlighting ----
    private fun highlightTab(view: View) {
        resetTabColors()
        view.setBackgroundColor(0xFF4CAF50.toInt()) // Active tab green
    }

    private fun resetTabColors() {
        binding.btnAll.setBackgroundColor(0xFF2D2F33.toInt())
        binding.btnBeginner.setBackgroundColor(0xFF2D2D2D.toInt())
        binding.btnIntermediate.setBackgroundColor(0xFF2D2D2D.toInt())
        binding.btnAdvanced.setBackgroundColor(0xFF2D2D2D.toInt())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
