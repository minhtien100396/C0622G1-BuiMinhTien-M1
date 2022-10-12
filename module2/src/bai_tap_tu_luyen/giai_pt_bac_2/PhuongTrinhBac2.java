package bai_tap_tu_luyen.giai_pt_bac_2;

import java.util.Scanner;

public class PhuongTrinhBac2 {

    /**
     * Giải phương trình bậc 2 ax^2+bx+c=0
     *
     * @param a - hệ số a
     * @param b - hệ số b
     * @param c - hệ số c
     */
    public static void giaiPhuongTrinhBac2(double a, double b, double c) {
        if (a == 0) {
            //Phương trình trở thành phương trình bậc 1 bx+c =0;
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình có vô số nghiệm");
                } else {
                    System.out.println("Phương trình vô nghiệm");
                }
            } else {
                System.out.printf("Phương trình có 1 nghiệm duy nhất: %f", (-c / b));
            }
        } else {
            //Phương trình bậc 2 : ax^2+bx+c=0
            double delta = Math.pow(b, 2) - 4 * a * c;
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            double x = -b / (2 * a);
            if (delta > 0) {
                System.out.printf("Phương trình có 2 nghiệm phân biệt:\nx1 = %.2f\nx2=%.2f", x1, x2);
            } else if (delta == 0) {
                System.out.printf("Phương trình có 1 nghiệm kép x1 = x2 = %.2f", x);
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Giải phương trình bậc 2");
        Scanner scanner = new Scanner(System.in);
        String check;
        do {
            System.out.println("Nhập a");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập b");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập c");
            double c = Double.parseDouble(scanner.nextLine());
            giaiPhuongTrinhBac2(a, b, c);
            System.out.println("\nBấm y để tiếp tục\nBấm n để kết thúc");
            check =  scanner.nextLine();
            if (check.equalsIgnoreCase("n")) {
                break;
            }
        } while (true); //btdk là true tức là vòng lặp vĩnh cửu , chỉ thoát ra khỏi vòng lặp khi nhập n
        System.out.println("Cám ơn bạn đã dùng phần mềm");
    }
}
