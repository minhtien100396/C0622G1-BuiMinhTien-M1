package kiem_tra.models;

import java.time.LocalDate;

public class NhanVien extends NhanSu {
    private double luong;
    private String phongBan;
    private String viTri;

    public NhanVien() {
    }

    public NhanVien(double luong, String phongBan, String viTri) {
        this.luong = luong;
        this.phongBan = phongBan;
        this.viTri = viTri;
    }

    public NhanVien(String maDinhDanh, String hoVaTen, String ngaySinh, String diaChi,
                    String soDienThoai, double luong, String phongBan, String viTri) {
        super(maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai);
        this.luong = luong;
        this.phongBan = phongBan;
        this.viTri = viTri;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getMaDinhDanh(), this.getHoVaTen(), this.getNgaySinh(), this.getDiaChi(), this.getSoDienThoai(),
                this.luong, this.phongBan, this.viTri);
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getMaDinhDanh(), this.getHoVaTen(), this.getNgaySinh(), this.getDiaChi(), this.getSoDienThoai(),
                this.luong, this.phongBan, this.viTri);
    }
}
