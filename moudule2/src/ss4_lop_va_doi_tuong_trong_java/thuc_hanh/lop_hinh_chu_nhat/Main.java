package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.lop_hinh_chu_nhat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chiều dài hình chữ nhật");
        double chieuDai = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập chiều rộng của hình chữ nhật");
        double chieuRong = Double.parseDouble(scanner.nextLine());
        HinhChuNhat hcn = new HinhChuNhat(chieuRong, chieuDai);
        System.out.println("Diện tích hình chữ nhật = " + hcn.getDienTichHinhChuNhat());
        System.out.println("Chu vi hình chữ nhật = " + hcn.getChuViHinhChuNhat());
        System.out.println("Thông tin của hình chữ nhật = " + hcn.getHienThiThongTin());
    }
}
