package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class SumOfNumbersInAColumn {
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
            isElemenns = elemens <= 0;
            if (isElemenns) {
                System.out.println("Số phần tử trong mảng 1 chiều là số nguyên dương ");
            }
        } while (isElemenns);

        int[][] arr = new int[row][elemens];
        int i;
        int j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < elemens; j++) {
                System.out.printf("Nhập vào giá trị cho phần tử arr[%d][%d] = ", i, j);
                arr[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        System.out.println("Nhập vào cột cần tính tổng");
        int columns;
        boolean isColumns;
        do {
            columns = Integer.parseInt(scanner.nextLine());
            isColumns = (columns < 0) || (columns > arr.length - 1);
            if (isColumns) {
                System.out.println("Cột bạn chọn không có trong vị trí của mảng");
            }
        } while (isColumns);
        int sum = 0;
        for (i = 0; i < arr.length; i++) {
            for (j = 0; j < arr[i].length; j++) {
                if (columns == j) {
                    sum += arr[i][j];
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("Tổng các số ở cột " + columns + " = %d", sum);
    }
}
