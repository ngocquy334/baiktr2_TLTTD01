package com.example.baitapkt02_tlttd01

data class CongViec(
    var maCongViec: String,
    var tenCongViec: String,
    var moTa: String,
    var trangThai: Boolean = false
) {
    // Hàm trả về thông tin đầy đủ của công việc
    fun thongTin(): String {
        val status = if (trangThai) "Hoàn thành" else "Chưa hoàn thành"
        return "Mã: $maCongViec\nTên: $tenCongViec\nMô tả: $moTa\nTrạng thái: $status"
    }

    // Hàm kiểm tra trạng thái
    fun laDaHoanThanh(): Boolean {
        return trangThai
    }
}
