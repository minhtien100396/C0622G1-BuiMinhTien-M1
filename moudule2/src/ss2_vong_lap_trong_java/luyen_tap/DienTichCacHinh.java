package ss2_vong_lap_trong_java.luyen_tap;

import java.util.Scanner;

public class DienTichCacHinh {
    public static void main(String[] args) {
        int choice = -1;
        double chieuDaiHinhChuNhat = -1;
        double chieuRongHinhChuNhat = -1;
        double canhHinhVuong = 0;
        double canhDayTamGiac = 0;
        double duongCaoTamGiac = 0;
        Scanner scanner = new Scanner(System.in);

        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Diện tích hình chữ nhật");
            System.out.println("2. Diện tích hình vuông");
            System.out.println("3. Diện tích tam giác ");
            System.out.println("0. Exit");
            System.out.println("Hãy nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    while (chieuDaiHinhChuNhat <= 0 || chieuRongHinhChuNhat <= 0) {
                        System.out.println("Nhập chiều dài HCN");
                        chieuDaiHinhChuNhat = scanner.nextDouble();
                        System.out.println("Nhập chiều rộng HCN");
                        chieuRongHinhChuNhat = scanner.nextDouble();
                    }
                    System.out.println("Diện tích HCN là : " + (chieuDaiHinhChuNhat * chieuRongHinhChuNhat));
                    break;

                case 2:
                    while (canhHinhVuong <= 0) {
                        System.out.println("Nhập cạnh hình vuông");
                        canhHinhVuong = scanner.nextDouble();
                    }
                    System.out.println("Diện tích hình vuông là : " + (canhHinhVuong * canhHinhVuong));
                    break;

                case 3:
                    while (canhDayTamGiac <= 0 || duongCaoTamGiac <= 0) {
                        System.out.println("Nhập cạnh đáy tam giác");
                        canhDayTamGiac = scanner.nextDouble();
                        System.out.println("Nhập đường cao tam giác");
                        duongCaoTamGiac = scanner.nextDouble();
                    }
                    System.out.println("Diện tích tam giác là : " + (0.5 * canhDayTamGiac * duongCaoTamGiac));
                    break;

                case 0:
                    System.out.println("Cám ơn bạn đã sử dụng hệ thống");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn của bạn không có. Hãy chọn lại");
            }
        }

    }
}
