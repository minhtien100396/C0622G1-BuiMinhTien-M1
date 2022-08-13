package bai_tap_tu_luyen.quan_ly_nhan_vien.model;

public class NhanVienPartTime extends NhanVien {
    private double gioLamViec;

    public NhanVienPartTime() {
    }

    @Override
    public double tinhLuong() {
        return getGioLamViec()*100;
    }

    public NhanVienPartTime(int maNhanVien, String tenNhanVien, int tuoiNhanVien, String phoneNhanVien, String mailNhanVien, double gioLamViec) {
        super(maNhanVien, tenNhanVien, tuoiNhanVien, phoneNhanVien, mailNhanVien);
        this.gioLamViec = gioLamViec;
    }

    public double getGioLamViec() {
        return gioLamViec;
    }

    public void setGioLamViec(double gioLamViec) {
        this.gioLamViec = gioLamViec;
    }

    @Override
    public String toString() {
        return "NhanVienPartTime{" +
                super.toString()+
                "gioLamViec=" + gioLamViec +
                '}';
    }
}
