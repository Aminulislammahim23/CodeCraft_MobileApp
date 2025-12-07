package com.example.codecraft.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.codecraft.LoginFragment
import com.example.codecraft.R
import com.example.codecraft.onboarding.OnboardingPage3Fragment
import com.example.codecraft.onboarding.OnboardingPage4Fragment

class OnboardingPage4Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_page4, container, false)

        val btnGetStarted: Button = view.findViewById(R.id.btnGetStarted)
        val btnBack: Button = view.findViewById(R.id.btnBack)


        btnGetStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }


        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnboardingPage3Fragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }

}