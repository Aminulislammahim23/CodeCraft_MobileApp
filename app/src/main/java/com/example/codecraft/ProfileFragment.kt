package com.example.codecraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.codecraft.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Dummy profile info
        binding.tvName.text = "Aminul Islam Mahim"
        binding.tvEmail.text = "mahim@example.com"

        // Stats
        binding.tvFollowers.text = "150"
        binding.tvFollowing.text = "200"
        binding.tvPosts.text = "52"

        // Edit Profile
        binding.btnEditProfile.setOnClickListener {
            // TODO: Add edit profile fragment
        }

        // Security Settings
        binding.btnSecurity.setOnClickListener {
            // TODO: Add security page
        }

        // Logout → back to login
        binding.btnLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, LoginFragment())
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
