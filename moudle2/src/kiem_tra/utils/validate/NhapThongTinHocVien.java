package kiem_tra.utils.validate;

import kiem_tra.models.HocVien;
import kiem_tra.models.NhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien.NhapDiem;
import kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien.NhapMaHocVien;
import kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien.NhapNgayNhapHoc;
import kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien.NhapTenLop;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapLuongNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapMaNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapPhongBanNhanVien;
import kiem_tra.utils.validate.nhap_thong_tin_nhan_vien.NhapViTriNhanVien;

import java.io.IOException;
import java.time.LocalDate;

public class NhapThongTinHocVien extends NhapThongTinNhanSu {
    public static String maDinhDanh;
    static double diemThi;
    static String tenLop;
    static String ngayNhapHoc;

    public static HocVien nhapThongTinHocVien() throws IOException {
        maDinhDanh = NhapMaHocVien.nhapMaHocVien();
        NhapThongTinNhanSu.nhapThongTinNhanSu();
        diemThi = NhapDiem.nhapDiem();
        tenLop = NhapTenLop.nhapTenLop();
        ngayNhapHoc = NhapNgayNhapHoc.nhapNgayNhapHoc();
        HocVien hocVien = new HocVien(maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai, diemThi, tenLop,
                ngayNhapHoc);
        return hocVien;
    }
}
