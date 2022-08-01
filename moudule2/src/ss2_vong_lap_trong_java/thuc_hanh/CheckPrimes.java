package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CheckPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số nguyên bất kì");
        int number = scanner.nextInt();

        if (number < 2) {
            System.out.println(number + " không phải là số nguyên tố");
        } else {
            int check = 0;
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    check++;
                }
            }
            if (check == 1) {
                System.out.println(number + " là số nguyên tố");
            } else {
                System.out.println(number + " không phải là số nguyên tố");
            }
        }
    }
}
