package com.example.codecraft

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.codecraft.ui.dashboard.DashboardFragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val edtUsername = view.findViewById<EditText>(R.id.etUsername)
        val edtPassword = view.findViewById<EditText>(R.id.etPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnGuest = view.findViewById<Button>(R.id.btnGuest)


        btnLogin.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username == "a" && password == "a") {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, DashboardFragment())
                    .addToBackStack(null)
                    .commit()
            } else {
                Toast.makeText(requireContext(), "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        btnGuest.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,HomepageFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
