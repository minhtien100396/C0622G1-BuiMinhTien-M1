package ss5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class Student {
    private int maSoSinhVien;
    private String hoVaTen;
    public static String truongHoc = "CodeGym";
    public String truong;
    //Khởi tạo constroctor có chứa tham số

    public Student(int maSoSinhVien, String hoVaTen) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoVaTen = hoVaTen;
    }

    public void doiTenTruongHoc(String truongHoc1) {
        this.truongHoc = truongHoc1;
    }
    public Student(int maSoSinhVien, String hoVaTen, String truong) {
        this.maSoSinhVien = maSoSinhVien;
        this.hoVaTen = hoVaTen;
        this.truong = truong;
    }

    public void hienThi() {
        System.out.println("Mã Số sinh viên:" + this.maSoSinhVien + "\n" + "Họ và tên Sinh viên: " + this.hoVaTen + "\n" + "Trường Học: " + this.truongHoc + "\n");
    }
    public void display(String truong) {
        System.out.println("Mã Số sinh viên:" + this.maSoSinhVien + "\n" + "Họ và tên Sinh viên: " + this.hoVaTen + "\n" + "Trường Học: " + truong + "\n");
    }
}
