package kiem_tra.utils.validate;

import kiem_tra.utils.validate.nhap_thong_tin_nhan_su.NhapDiaChi;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_su.NhapNgaySinh;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_su.NhapSoDienThoai;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_su.NhapTen;

import java.time.LocalDate;

public class NhapThongTinNhanSu {
    public static String hoVaTen;
    public static String ngaySinh;
    public static String diaChi;
    public static String soDienThoai;

    public static void nhapThongTinNhanSu() {
        hoVaTen = NhapTen.nhapTen();
        ngaySinh = NhapNgaySinh.nhapNgaySinh();
        diaChi = NhapDiaChi.nhapDiaChi();
        soDienThoai = NhapSoDienThoai.nhapSoDienThoai();
    }

}
