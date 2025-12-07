package com.example.codecraft.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.codecraft.R
import com.example.codecraft.onboarding.OnboardingPage4Fragment
import com.example.codecraft.onboarding.OnboardingPage2Fragment

class OnboardingPage3Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_onboarding_page3, container, false)

        val btnNext: Button = view.findViewById(R.id.btnNext)
        val btnBack: Button = view.findViewById(R.id.btnBack)

        btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardingPage4Fragment())
                .addToBackStack(null)
                .commit()
        }


        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardingPage2Fragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }

}