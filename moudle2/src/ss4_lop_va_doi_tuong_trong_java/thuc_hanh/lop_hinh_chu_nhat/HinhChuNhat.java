package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.lop_hinh_chu_nhat;

public class HinhChuNhat {
    double chieuRong;
    double chieuDai;

    public HinhChuNhat(double chieuRong, double chieuDai) {
        this.chieuRong = chieuRong;
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return this.chieuRong;
    }

    public double getChieuDai() {
        return this.chieuDai;
    }

    public double setChieuRong(double chieuRong) {
        return this.chieuRong = chieuRong;
    }

    public void setChieuDai(double chieuDai) {
         this.chieuDai = chieuDai;
    }

    public double getDienTichHinhChuNhat() {
        return this.chieuDai * this.chieuRong;
    }

    public double getChuViHinhChuNhat() {
        return (this.chieuDai + this.chieuRong) * 2;
    }

    public String getHienThiThongTin() {
        return "\nChiều dài = " + this.getChieuDai() + "\nChiều rộng = " + this.getChieuRong();
    }
}
