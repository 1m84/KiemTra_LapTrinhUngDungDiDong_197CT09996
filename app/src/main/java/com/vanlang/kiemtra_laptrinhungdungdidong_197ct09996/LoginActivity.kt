package com.vanlang.kiemtra_laptrinhungdungdidong_197ct09996

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ánh xạ View bằng findViewById truyền thống
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        btnLogin.setOnClickListener {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val email = etEmail.text.toString().trim()
        val password = etPassword.text.toString().trim()

        if (email.isEmpty() && password.isEmpty()) {
            showError("Vui lòng nhập Email và Mật khẩu!")
        } else if (email.isEmpty()) {
            showError("Vui lòng nhập Email!")
        } else if (password.isEmpty()) {
            showError("Vui lòng nhập Mật khẩu!")
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showError("Email sai định dạng!")
        } else if (password.length < 6) {
            showError("Mật khẩu phải có ít nhất 6 ký tự!")
        } else {
            showSuccess("Xác thực thành công!")

            // Khởi tạo Intent tường minh chuyển sang ProfileActivity và truyền Email qua putExtra
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_EMAIL", email)
            }
            startActivity(intent)
        }
    }

    private fun showError(message: String) {
        tvStatus.text = message
        tvStatus.setTextColor(Color.RED)
    }

    private fun showSuccess(message: String) {
        tvStatus.text = message
        tvStatus.setTextColor("#388E3C".toColorInt())
    }
}