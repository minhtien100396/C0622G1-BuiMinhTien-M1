package ss4_lop_va_doi_tuong_trong_java.bai_tap.phuong_trinh_bac_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập a");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập b");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập c");
        double c = Double.parseDouble(scanner.nextLine());
        QuadraticEquation quadraticEquation2 = new QuadraticEquation(a, b, c);
        double delta = quadraticEquation2.getDiscriminant();
        System.out.println("Delta = " + delta);
        if (delta > 0) {
            System.out.println("Phương trình có 2 nghiệm phân biệt là: ");
            System.out.println("x1 = " + quadraticEquation2.getGetRoot1());
            System.out.println("x2 = " + quadraticEquation2.getGetRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có 1 nghiệm duy nhất x1 = x2 = " + quadraticEquation2.getGetRoot());
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
