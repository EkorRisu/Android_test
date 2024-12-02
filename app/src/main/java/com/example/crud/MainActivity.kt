package com.example.curd

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        usernameEditText = findViewById(R.id.editTextText2)
        passwordEditText = findViewById(R.id.editTextTextPassword2)
        loginButton = findViewById(R.id.button2)
        registerTextView = findViewById(R.id.textView3)

        // Set up the click listener for the Login button
        loginButton.setOnClickListener {
            login()
        }

        // Set up the click listener for the Register text link
        registerTextView.setOnClickListener {
            register()
        }
    }

    private fun login() {
        // Retrieve entered username and password
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Validate inputs
        when {
            username.isEmpty() && password.isEmpty() -> {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
            username.isEmpty() -> {
                Toast.makeText(this, "Please enter username", Toast.LENGTH_SHORT).show()
            }
            password.isEmpty() -> {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show()
            }
            else -> {
                // Mock authentication (replace with actual logic)
                if (username == "testuser" && password == "testpassword") {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    // Proceed to next screen (for example, Main Dashboard)
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun register() {
        // Redirect to Register Activity
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}
