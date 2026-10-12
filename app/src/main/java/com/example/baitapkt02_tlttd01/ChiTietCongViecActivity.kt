package com.example.baitapkt02_tlttd01

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var txtChiTiet: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        // Ánh xạ TextView từ layout
        txtChiTiet = findViewById(R.id.txtChiTiet)

        // Nhận dữ liệu từ Intent
        val ten = intent.getStringExtra("tenCongViec")
        val moTa = intent.getStringExtra("moTaCongViec")

        // Hiển thị dữ liệu
        txtChiTiet.text = "Tên: $ten\nMô tả: $moTa"
    }
}
