package com.example.codecraft.ui.dashboard

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codecraft.R
import com.example.codecraft.databinding.FragmentDashboardBinding
import com.example.codecraft.CoursesFragment
import com.example.codecraft.FavoritesFragment
import com.example.codecraft.HomepageFragment
import com.example.codecraft.ProfileFragment

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private var activeColor = Color.parseColor("#FFFFFF")
    private var inactiveColor = Color.parseColor("#888888")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setActiveIcon(binding.iconHome)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        binding.navHome.setOnClickListener {
            replaceFragment(HomepageFragment())
            setActiveIcon(binding.iconHome)
        }

        binding.navCourses.setOnClickListener {
            replaceFragment(CoursesFragment())
            setActiveIcon(binding.iconCourses)
        }

        binding.navFavorites.setOnClickListener {
            replaceFragment(FavoritesFragment())
            setActiveIcon(binding.iconFavorites)
        }

        binding.navProfile.setOnClickListener {
            replaceFragment(ProfileFragment())
            setActiveIcon(binding.iconProfile)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun setActiveIcon(activeIcon: View) {
        binding.iconHome.setColorFilter(inactiveColor)
        binding.iconCourses.setColorFilter(inactiveColor)
        binding.iconFavorites.setColorFilter(inactiveColor)
        binding.iconProfile.setColorFilter(inactiveColor)

        (activeIcon as? androidx.appcompat.widget.AppCompatImageView)?.setColorFilter(activeColor)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
