package com.example.curd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize UI elements
        usernameEditText = findViewById(R.id.editTextText2)  // Periksa ID di XML
        passwordEditText = findViewById(R.id.editTextTextPassword2)  // Periksa ID di XML
        confirmPasswordEditText = findViewById(R.id.editTextTextPassword)  // Periksa ID di XML
        registerButton = findViewById(R.id.button2)

        // Set up the click listener for the Register button
        registerButton.setOnClickListener {
            register()
        }
    }

    private fun register() {
        // Retrieve entered username, password, and confirm password
        val username = usernameEditText.text.toString()
        val password = passwordEditText.text.toString()
        val confirmPassword = confirmPasswordEditText.text.toString()

        // Validate inputs
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        } else if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
        } else if (password.length < 6) { // Validasi panjang password minimum
            Toast.makeText(this, "Password should be at least 6 characters long", Toast.LENGTH_SHORT).show()
        } else {
            // Here you can save the user data to your backend or local storage
            // Example: saveToBackend(username, password)

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

            // Redirect back to login screen
            finish() // This will close RegisterActivity and return to previous activity (LoginActivity)
        }
    }

    // Optionally add method for backend storage or SharedPreferences
    // private fun saveToBackend(username: String, password: String) {
    //     // Implement backend saving logic here
    // }
}
