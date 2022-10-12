package kiem_tra.models;

public class HocVien extends NhanSu {
    private double diemThi;
    private String tenLop;
    private String ngayNhapHoc;

    public HocVien() {
    }

    public HocVien(double diemThi, String tenLop, String ngayNhapHoc) {
        this.diemThi = diemThi;
        this.tenLop = tenLop;
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public HocVien(String maDinhDanh, String hoVaTen, String ngaySinh, String diaChi,
                   String soDienThoai, double diemThi, String tenLop, String ngayNhapHoc) {
        super(maDinhDanh, hoVaTen, ngaySinh, diaChi, soDienThoai);
        this.diemThi = diemThi;
        this.tenLop = tenLop;
        this.ngayNhapHoc = ngayNhapHoc;
    }

    public double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(double diemThi) {
        this.diemThi = diemThi;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNgayNhapHoc() {
        return ngayNhapHoc;
    }

    public void setNgayNhapHoc(String ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getMaDinhDanh(), this.getHoVaTen(), this.getNgaySinh(), this.getDiaChi(), this.getSoDienThoai(),
                this.diemThi, this.tenLop, this.ngayNhapHoc);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", this.getMaDinhDanh(), this.getHoVaTen(), this.getNgaySinh(), this.getDiaChi(), this.getSoDienThoai(),
                this.diemThi, this.tenLop, this.ngayNhapHoc);
    }
}
