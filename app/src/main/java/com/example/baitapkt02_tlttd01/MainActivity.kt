package com.example.baitapkt02_tlttd01

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
data class CongViec(
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) {
    fun thongTin(): String {
        val status = if (trangThai) "Hoàn thành" else "Chưa hoàn thành"
        return "Tên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $status"
    }
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtSV = findViewById<TextView>(R.id.txtThongTinSV)
        val edtTen = findViewById<EditText>(R.id.edtTenCongViec)
        val edtMoTa = findViewById<EditText>(R.id.edtMoTaCongViec)
        val btnTao = findViewById<Button>(R.id.btnTaoCongViec)
        val btnDanhSach = findViewById<Button>(R.id.btnXemDanhSach)

        txtSV.text = "Trương Ngọc Quý - msv:2415053122235 - TLTTD01"

        btnTao.setOnClickListener {
            val ten = edtTen.text.toString().trim()
            val moTa = edtMoTa.text.toString().trim()

            if (ten.isEmpty()) {
                Toast.makeText(this, "Tên công việc không được để trống", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, ChiTietCongViecActivity::class.java).apply {
                    putExtra("tenCongViec", ten)
                    putExtra("moTaCongViec", moTa)
                })
            }
        }

        btnDanhSach.setOnClickListener {
            Toast.makeText(this, "Chức năng xem danh sách sẽ bổ sung sau", Toast.LENGTH_SHORT).show()
        }
    }
}
