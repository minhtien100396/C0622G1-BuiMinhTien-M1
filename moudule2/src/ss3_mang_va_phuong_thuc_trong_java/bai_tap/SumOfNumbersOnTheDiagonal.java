package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfNumbersOnTheDiagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng cho mảng 2 chiều");
        int row;
        boolean isRow;
        do {
            row = Integer.parseInt(scanner.nextLine());
            isRow = row <= 0;
            if (isRow) {
                System.out.println("Số hàng trong mảng 2 chiều là số nguyên dương ");
            }
        } while (isRow);

        System.out.println("Nhập số phần tử cho mảng 1 chiều nằm trong mảng 2 chiều");
        int elemens;
        boolean isElemenns;
        do {
            elemens = Integer.parseInt(scanner.nextLine());
            isElemenns = (elemens != row);
            if (isElemenns) {
                System.out.println("Mảng cần tạo là một ma trận vuông. Do đó số hàng và cột phải bằng nhau.");
            }
        } while (isElemenns);

        int[][] arr = new int[row][elemens];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < elemens; j++) {
                System.out.printf("Nhập vào giá trị cho phần tử arr[%d][%d] = ", i, j);
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("Tổng các số ở đường chéo là: sum = %d", sum);

    }
}
