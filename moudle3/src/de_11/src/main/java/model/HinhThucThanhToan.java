package model;

public class HinhThucThanhToan {
    private int maThanhToan;
    private String tenHinhThucThanhToan;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(int maThanhToan, String tenHinhThucThanhToan) {
        this.maThanhToan = maThanhToan;
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }

    public int getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(int maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public String getTenHinhThucThanhToan() {
        return tenHinhThucThanhToan;
    }

    public void setTenHinhThucThanhToan(String tenHinhThucThanhToan) {
        this.tenHinhThucThanhToan = tenHinhThucThanhToan;
    }
}
