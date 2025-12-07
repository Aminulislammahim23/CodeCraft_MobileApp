package com.example.codecraft.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.codecraft.HomepageFragment
import com.example.codecraft.LoginFragment
import com.example.codecraft.R


class OnboardingPage5Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_onboarding_page5, container, false)
        val btnGetStarted: Button = view.findViewById(R.id.btnGetStarted)


        btnGetStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }


        return view
    }

}

