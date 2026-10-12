package com.example.baitapkt02_tlttd01

data class CongViec(
    var maCongViec: String,
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) {
    fun thongTin(): String {
        val status = if (trangThai) "Hoàn thành" else "Chưa hoàn thành"
        return "Mã: $maCongViec\nTên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $status"
    }

    fun laDaHoanThanh(): Boolean {
        return trangThai
    }
}
