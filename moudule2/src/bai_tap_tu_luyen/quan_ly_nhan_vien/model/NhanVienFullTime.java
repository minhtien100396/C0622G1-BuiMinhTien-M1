package bai_tap_tu_luyen.quan_ly_nhan_vien.model;

public class NhanVienFullTime extends NhanVien {
    private double thuong;
    private double phat;
    private double luongCung;

    public NhanVienFullTime() {
    }

    @Override
    public double tinhLuong() {
        return getLuongCung()+(getThuong()-getPhat());
    }

    public NhanVienFullTime(int maNhanVien, String tenNhanVien, int tuoiNhanVien, String phoneNhanVien, String mailNhanVien, double thuong, double phat, double luongCung) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, phoneNhanVien, mailNhanVien);
        this.thuong = thuong;
        this.phat = phat;
        this.luongCung = luongCung;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    public double getPhat() {
        return phat;
    }

    public void setPhat(double phat) {
        this.phat = phat;
    }

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    @Override
    public String toString() {
        return "NhanVienFullTime{" +
                super.toString()+
                "thuong=" + thuong +
                ", phat=" + phat +
                ", luongCung=" + luongCung +
                '}';
    }
}
