package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TemperatureSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        double doF;
        double doC;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Đổi từ độ C sang độ F");
            System.out.println("2. Đổi từ độ F sang độ C");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập độ F:\t");
                    doF = Double.parseDouble(scanner.nextLine());
                    System.out.println("Độ C = " + convertFToC(doF));
                    break;
                case 2:
                    System.out.print("Nhập độ C:\t");
                    doC = Double.parseDouble(scanner.nextLine());
                    System.out.println("Độ F = " + convertCToF(doC));
                    break;
            }
        }

    }

    public static double convertFToC(double f) {
        double c = (5.0 / 9) * (f - 32.0);
        return c;
    }

    public static double convertCToF(double c) {
        double f = (9.0 / 5) * c + 32;
        return f;
    }
}
