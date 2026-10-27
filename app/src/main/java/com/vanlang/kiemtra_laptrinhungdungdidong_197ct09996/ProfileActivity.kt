package com.vanlang.kiemtra_laptrinhungdungdidong_197ct09996

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvUserEmail: TextView
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2.2. Ánh xạ View bằng findViewById truyền thống
        tvUserEmail = findViewById(R.id.tvUserEmail)
        btnLogout = findViewById(R.id.btnLogout)

        // 2.4. Trích xuất dữ liệu Email truyền qua Intent từ LoginActivity
        val email = intent.getStringExtra("EXTRA_EMAIL")
        if (!email.isNullOrEmpty()) {
            tvUserEmail.text = "Email: $email"
        }

        // 2.5. Xử lý Đăng xuất: gọi finish() để đóng màn hình hiện tại và quay về LoginActivity
        btnLogout.setOnClickListener {
            finish()
        }
    }
}