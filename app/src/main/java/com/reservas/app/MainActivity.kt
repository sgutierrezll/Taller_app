package com.reservas.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.reservas.app.webservice.LoginViewModel
import com.reservas.app.webservice.LoginViewModelFactory


class MainActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(this)
    }

    //private val viewModel: LoginViewModel by viewModels { LoginViewModelFactory(TokenManager(this))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            viewModel.login(username, password)
//            this.getImages();
        }

        viewModel.loginResult.observe(this) { result ->
            result.onSuccess { loginResponse ->
                Toast.makeText(this, "Login Successful: ${loginResponse.token}", Toast.LENGTH_SHORT).show()
                // Navigate to next activity or handle success
            }.onFailure { exception ->
                Toast.makeText(this, "Login Failed: ${exception.message}", Toast.LENGTH_SHORT).show()
                // Handle error
            }
        }
    }
}