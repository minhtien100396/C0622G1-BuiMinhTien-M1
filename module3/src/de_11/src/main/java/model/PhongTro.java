package model;

public class PhongTro {
    private int maPhongTro;
    private String tenNguoiThueTro;
    private String soDienThoai;
    private String ngayBatDauThueTro;
    private int maThanhToan;
    private String ghiChu;

    public PhongTro() {
    }

    public PhongTro(String tenNguoiThueTro, String soDienThoai, String ngayBatDauThueTro, int maThanhToan, String ghiChu) {
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThueTro = ngayBatDauThueTro;
        this.maThanhToan = maThanhToan;
        this.ghiChu = ghiChu;
    }

    public PhongTro(int maPhongTro, String tenNguoiThueTro, String soDienThoai, String ngayBatDauThueTro, int maThanhToan, String ghiChu) {
        this.maPhongTro = maPhongTro;
        this.tenNguoiThueTro = tenNguoiThueTro;
        this.soDienThoai = soDienThoai;
        this.ngayBatDauThueTro = ngayBatDauThueTro;
        this.maThanhToan = maThanhToan;
        this.ghiChu = ghiChu;
    }

    public int getMaPhongTro() {
        return maPhongTro;
    }

    public void setMaPhongTro(int maPhongTro) {
        this.maPhongTro = maPhongTro;
    }

    public String getTenNguoiThueTro() {
        return tenNguoiThueTro;
    }

    public void setTenNguoiThueTro(String tenNguoiThueTro) {
        this.tenNguoiThueTro = tenNguoiThueTro;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getNgayBatDauThueTro() {
        return ngayBatDauThueTro;
    }

    public void setNgayBatDauThueTro(String ngayBatDauThueTro) {
        this.ngayBatDauThueTro = ngayBatDauThueTro;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}