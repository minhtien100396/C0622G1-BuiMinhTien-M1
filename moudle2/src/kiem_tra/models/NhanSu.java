package kiem_tra.models;

import java.time.LocalDate;

public abstract class NhanSu {
    private String maDinhDanh;
    private String hoVaTen;
    private String ngaySinh;
    private String diaChi;
    private String soDienThoai;

    public NhanSu() {
    }

    public NhanSu(String maDinhDanh, String hoVaTen, String ngaySinh, String diaChi,
                  String soDienThoai) {
        this.maDinhDanh = maDinhDanh;
        this.hoVaTen = hoVaTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getMaDinhDanh() {
        return maDinhDanh;
    }

    public void setMaDinhDanh(String maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public abstract String getInfo();

    @Override
    public String toString() {
        return "NhanSu{" +
                "maDinhDanh='" + maDinhDanh + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                '}';
    }
}
