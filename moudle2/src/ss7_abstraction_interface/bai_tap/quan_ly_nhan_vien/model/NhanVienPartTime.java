package ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model;

public class NhanVienPartTime extends NhanVien {
    private double gioLam;

    public NhanVienPartTime() {
    }

    public double getGioLam() {
        return gioLam;
    }

    public void setGioLam(double gioLam) {
        this.gioLam = gioLam;
    }

    public NhanVienPartTime(String maNhanVien, String tenNhanVien, String soDienThoai, String email, double gioLam) {
        super(maNhanVien, tenNhanVien, soDienThoai, email);
        this.gioLam = gioLam;
    }

    @Override
    public double getLuong() {
        return getGioLam() * 100;
    }

    @Override
    public String toString() {
        return "NhanVienPartTime{" +
                super.toString()+
                "gioLam=" + gioLam +
                '}';
    }
}
