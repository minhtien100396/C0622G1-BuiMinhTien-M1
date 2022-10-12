package bai_tap_tu_luyen.tinh_tong_s_n;

import java.util.Scanner;

public class tinhTong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập x");
        double x = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập n ");
        double n = Integer.parseInt(scanner.nextLine());
        System.out.printf("sum = %.2f", tong(2, 3));
    }

    public static double tong(int x, int n) {
        double tuSo = 0;
        double mauSo = 0;
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            tuSo = Math.pow(x, i);
            mauSo += i;
            sum += tuSo / mauSo;

        }
        return sum;
    }
}
