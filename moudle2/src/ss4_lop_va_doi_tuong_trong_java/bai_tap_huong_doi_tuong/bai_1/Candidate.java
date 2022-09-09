package ss4_lop_va_doi_tuong_trong_java.bai_tap_huong_doi_tuong.bai_1;

import java.util.Arrays;

public class Candidate {
    private int ma;
    private String ten;
    private String ngayThangNamSinh;
    private double diemThiToan;
    private double diemThiVan;
    private double diemThiAnh;

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNgayThangNamSinh() {
        return ngayThangNamSinh;
    }

    public double getDiemThiToan() {
        return diemThiToan;
    }

    public double getDiemThiVan() {
        return diemThiVan;
    }

    public double getDiemThiAnh() {
        return diemThiAnh;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgayThangNamSinh(String ngayThangNamSinh) {
        this.ngayThangNamSinh = ngayThangNamSinh;
    }

    public void setDiemThiToan(double diemThiToan) {
        this.diemThiToan = diemThiToan;
    }

    public void setDiemThiVan(double diemThiVan) {
        this.diemThiVan = diemThiVan;
    }

    public void setDiemThiAnh(double diemThiAnh) {
        this.diemThiAnh = diemThiAnh;
    }

    public void hienThiArray(String [] arr){
        System.out.println(Arrays.toString(arr));
    }
}
