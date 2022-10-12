package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsPass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng sinh viên của lớp");
        int number;
        boolean isNumber;
        do {
            number = Integer.parseInt(scanner.nextLine());
            isNumber = number <= 0 || number > 10;
            if (isNumber) {
                System.out.println("Số lượng sinh viên trong lớp nhỏ hơn 11 và là số dương");
            }
        } while (isNumber);

        int[] arr = new int[number];

        for (int i = 0; i < number; i++) {
            System.out.printf("Điểm sinh viên thứ " + (i + 1) + " là arr[%d] = ", i);
            do {
                arr[i] = Integer.parseInt(scanner.nextLine());
                if (arr[i] < 0 || arr[i] > 10) {
                    System.out.println("Số điểm phải từ 0 - 10. Hãy nhập lại");
                }
            } while (arr[i] < 0 || arr[i] > 10);

            System.out.println();
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                count++;
            }
        }
        System.out.println("Số lượng sinh viên thi đỗ là: " + count);
    }
}
