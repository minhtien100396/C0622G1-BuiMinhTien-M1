package bai_tap_tu_luyen.quan_ly_nhan_vien.model;

public abstract class  NhanVien {
    private int maNhanVien;
    private String tenNhanVien;
    private int tuoiNhanVien;
    private String phoneNhanVien;
    private String mailNhanVien;

    public NhanVien() {
    }

    public NhanVien(int maNhanVien, String tenNhanVien, int tuoiNhanVien, String phoneNhanVien, String mailNhanVien) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoiNhanVien = tuoiNhanVien;
        this.phoneNhanVien = phoneNhanVien;
        this.mailNhanVien = mailNhanVien;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoiNhanVien() {
        return tuoiNhanVien;
    }

    public void setTuoiNhanVien(int tuoiNhanVien) {
        this.tuoiNhanVien = tuoiNhanVien;
    }

    public String getPhoneNhanVien() {
        return phoneNhanVien;
    }

    public void setPhoneNhanVien(String phoneNhanVien) {
        this.phoneNhanVien = phoneNhanVien;
    }

    public String getMailNhanVien() {
        return mailNhanVien;
    }

    public void setMailNhanVien(String mailNhanVien) {
        this.mailNhanVien = mailNhanVien;
    }
    public abstract double tinhLuong();

    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien=" + maNhanVien +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", tuoiNhanVien=" + tuoiNhanVien +
                ", phoneNhanVien='" + phoneNhanVien + '\'' +
                ", mailNhanVien='" + mailNhanVien + '\'' +
                '}';
    }
}
