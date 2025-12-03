package com.example.codecraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.codecraft.databinding.FragmentSignupBinding

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSignUp.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Implement your user registration logic here (e.g., with Firebase Authentication)
                Toast.makeText(context, "Registration logic goes here", Toast.LENGTH_SHORT).show()

                // For now, let's navigate to the dashboard after a successful "sign up"
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DashboardFragment())
                    .commit()
            }
        }

        binding.tvGoToLogin.setOnClickListener {
            // TODO: Navigate to your LoginFragment
            // For example:
            /*
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LoginFragment())
                .commit()
            */
            Toast.makeText(context, "Navigate to Login Screen", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
