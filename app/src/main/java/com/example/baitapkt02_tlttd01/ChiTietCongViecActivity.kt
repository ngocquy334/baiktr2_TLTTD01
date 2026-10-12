package com.example.baitapkt02_tlttd01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietCongViecActivity : AppCompatActivity() {

    private lateinit var txtChiTiet: TextView
    private lateinit var btnChinhSua: Button
    private lateinit var chkHoanThanh: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_cong_viec)

        txtChiTiet = findViewById(R.id.txtChiTiet)
        btnChinhSua = findViewById(R.id.btnChinhSua)
        chkHoanThanh = findViewById(R.id.chkHoanThanh)

        val ten = intent.getStringExtra("tenCongViec")
        val moTa = intent.getStringExtra("moTaCongViec")
        txtChiTiet.text = "Tên: $ten\nMô tả: $moTa\nTrạng thái: Chưa hoàn thành"

        val editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val tenMoi = data?.getStringExtra("tenMoi")
                val moTaMoi = data?.getStringExtra("moTaMoi")
                txtChiTiet.text = "Tên: $tenMoi\nMô tả: $moTaMoi\nTrạng thái: ${if (chkHoanThanh.isChecked) "Hoàn thành" else "Chưa hoàn thành"}"
            }
        }

        btnChinhSua.setOnClickListener {
            val intent = Intent(this, ChinhSuaCongViecActivity::class.java)
            editLauncher.launch(intent)
        }

        chkHoanThanh.setOnCheckedChangeListener { _, isChecked ->
            val trangThai = if (isChecked) "Hoàn thành" else "Chưa hoàn thành"
            val noiDung = txtChiTiet.text.toString().substringBefore("\nTrạng thái:")
            txtChiTiet.text = "$noiDung\nTrạng thái: $trangThai"
        }
        val btnHoanThanh = findViewById<Button>(R.id.btnHoanThanh)

        btnHoanThanh.setOnClickListener {
            CongViec.trangThai = true
            txtChiTiet.text = CongViec.thongTin()
        }

    }
}
