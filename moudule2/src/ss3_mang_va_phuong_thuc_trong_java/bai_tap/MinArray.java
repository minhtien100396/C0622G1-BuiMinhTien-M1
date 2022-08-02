package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class MinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử cho mảng");
        int number;
        boolean isNumber;
        do {
            number = Integer.parseInt(scanner.nextLine());
            isNumber = number <= 0;
            if (isNumber) {
                System.out.println("Số lượng phần tử phải là số dương");
            }
        } while (isNumber);

        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.printf("Nhập vào arr[%d] = ", i);
            arr[i] = Integer.parseInt(scanner.nextLine());
        }

        int min = arr[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.printf("Giá trị nhỏ nhất trong mảng là: min = '%d' ", min);
        System.out.println();
        System.out.printf("Vị trí của min là: index = %d", index);
    }
}
