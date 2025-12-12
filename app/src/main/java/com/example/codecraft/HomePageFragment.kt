package com.example.codecraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codecraft.databinding.FragmentHomePageBinding
import com.example.codecraft.adapters.CourseAdapter
import com.example.codecraft.models.CourseModel

class HomepageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTopSection()
        setupOfferCard()
        setupPopularCourses()
        setupBottomNavigation()
    }

    private fun setupTopSection() {
        binding.welcomeText.text = "Hello John!"
    }

    private fun setupOfferCard() {
        binding.offerTitle.text = "Limited Time Offer"
        binding.offerSubtitle.text = "30% OFF for all Courses"
    }

    private fun setupPopularCourses() {

        val courseList = listOf(
            CourseModel(
                title = "UX/UI Design",
                duration = "5h 30 min",
                rating = 4.9,
                reviews = 322,
                image = com.example.codecraft.R.drawable.course_uiux
            ),
            CourseModel(
                title = "Web Development",
                duration = "5h 30 min",
                rating = 4.8,
                reviews = 294,
                image = com.example.codecraft.R.drawable.course_webdev
            ),
            CourseModel(
                title = "Mobile App Dev",
                duration = "7h 20 min",
                rating = 4.7,
                reviews = 401,
                image = com.example.codecraft.R.drawable.course_mobile
            )
        )

        binding.popularRecycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.popularRecycler.adapter = CourseAdapter(courseList)
    }

    private fun setupBottomNavigation() {
        binding.navHome.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomepageFragment())
                .commit()
        }

        binding.navCourses.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, CoursesFragment())
                .commit()
        }

        binding.navFavorites.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FavoritesFragment())
                .commit()
        }

        binding.navProfile.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ProfileFragment())
                .addToBackStack(null)
                .commit()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
