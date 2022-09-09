package kiem_tra.utils.validate;

import case_study.task_1.models.Employee;
import case_study.task_1.utils.InputPerson;
import case_study.task_1.utils.validate.input_employee.InputIdEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputLevelOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputPositionOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputSalaryOfEmployeeUltils;
import kiem_tra.models.NhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapLuongNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapMaNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapPhongBanNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapViTriNhanVien;

import java.io.IOException;

public class NhapThongTinNhanVien extends NhapThongTinNhanSu {
    public static String maDinhDanh;
    static double luong;
    static String phongBan;
    static String viTri;

    public static NhanVien nhapThongTinNhanVien() throws IOException {
        maDinhDanh = NhapMaNhanVien.nhapMaNhanVien();
        NhapThongTinNhanSu.nhapThongTinNhanSu();
        luong = NhapLuongNhanVien.nhapLuongNhanVien();
        phongBan = NhapPhongBanNhanVien.nhapPhongBanNhanVien();
        viTri = NhapViTriNhanVien.nhapViTriNhanVien();
        NhanVien nhanVien = new NhanVien(maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai, luong, phongBan,
                viTri);
        return nhanVien;
    }
}
