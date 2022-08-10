package ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model;

public class NhanVienFullTime extends NhanVien {
    private double luongCung;
    private double luongThuong;
    private double tienPhat;

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    public double getTienPhat() {
        return tienPhat;
    }

    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }

    public NhanVienFullTime(double luongCung) {
        this.luongCung = luongCung;
    }


    public NhanVienFullTime(String maNhanVien, String tenNhanVien, String soDienThoai, String email, double luongCung, double luongThuong, double tienPhat) {
        super(maNhanVien, tenNhanVien, soDienThoai, email);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.tienPhat = tienPhat;
    }

    public NhanVienFullTime() {
    }

    @Override
    public double getLuong() {
        return getLuongCung() + (getLuongThuong() - getTienPhat());
    }

    @Override
    public String toString() {
        return "NhanVienFullTime{" +
                super.toString()+
                "luongCung=" + luongCung +
                ", luongThuong=" + luongThuong +
                ", tienPhat=" + tienPhat +
                '}';
    }
}
