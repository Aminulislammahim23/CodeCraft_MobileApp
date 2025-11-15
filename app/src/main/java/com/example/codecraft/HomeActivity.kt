package com.example.codecraft

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    private var username: String = "John Doe" // Example, replace with actual user data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnCourses = findViewById<Button>(R.id.btnCourses)
        val btnCertificates = findViewById<Button>(R.id.btnCertificates)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Open CoursesActivity with user data
        btnCourses.setOnClickListener {
            val intent = Intent(this, CoursesActivity::class.java)
            intent.putExtra("username", username)  // Passing data
            startActivity(intent)
        }

        // Open CertificatesActivity with user data
        btnCertificates.setOnClickListener {
            val intent = Intent(this, CertificatesActivity::class.java)
            intent.putExtra("username", username)  // Passing data
            startActivity(intent)
        }

        // Logout with confirmation dialog
        btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Yes") { _, _ ->
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}


