package ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.controller;

import ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model.NhanVien;
import ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model.NhanVienFullTime;
import ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model.NhanVienPartTime;
import ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model.QuanLyNhanVien;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        NhanVien nhanVien1 = new NhanVienFullTime("1", "Tiến", "111111111", "minhtien", 100, 1000, 500);
        NhanVien nhanVien2 = new NhanVienFullTime("2", "Cường", "2222222222", "Cươngseven", 2000, 2000, 1000);
        NhanVien nhanVien5 = new NhanVienFullTime("2", "Cường", "2222222222", "Cươngseven", 1000, 2000, 1000);
        NhanVien nhanVien3 = new NhanVienPartTime("3", "Nam", "33333", "namda", 8);
        NhanVien nhanVien4 = new NhanVienPartTime("4", "Tuấn", "444444", "namda", 5);
        List<NhanVien> nhanVienList = new ArrayList<>();
        nhanVienList.add(nhanVien1);
        nhanVienList.add(nhanVien2);
        nhanVienList.add(nhanVien3);
        nhanVienList.add(nhanVien4);
        nhanVienList.add(nhanVien5);
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        quanLyNhanVien.setNhanVienList(nhanVienList);
//        quanLyNhanVien.hienThiNhanVien();
//        quanLyNhanVien.themNhanVien(nhanVien2);
//        quanLyNhanVien.hienThiNhanVien();
//        quanLyNhanVien.tinhLuongPhaiTra();
        quanLyNhanVien.hienThiNhanVien();
        quanLyNhanVien.sapXepNhanVienFullTime();
    }
}
