package com.example.codecraft

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val btnCourses = findViewById<Button>(R.id.btnCourses)
        val btnCertificates = findViewById<Button>(R.id.btnCertificates)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnCourses.setOnClickListener {
            Toast.makeText(this, "Opening Courses...", Toast.LENGTH_SHORT).show()
        }

        btnCertificates.setOnClickListener {
            Toast.makeText(this, "Opening Certificates...", Toast.LENGTH_SHORT).show()
        }

        btnLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
