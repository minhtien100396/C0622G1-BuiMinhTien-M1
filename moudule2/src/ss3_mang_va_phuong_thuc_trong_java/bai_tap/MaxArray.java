package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class MaxArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Nhập số phần tử cho mảng 2 chiều
        int elementsArray2;
        boolean isInvalidelEmentsArray2;
        System.out.println("Nhập số phần tử cho mảng 2 chiều");
        do {
            elementsArray2 = Integer.parseInt(scanner.nextLine());
            isInvalidelEmentsArray2 = elementsArray2 <= 0;
            if (isInvalidelEmentsArray2) {
                System.out.println("Số phần tử trong mảng phải là số dương");
            }
        } while (isInvalidelEmentsArray2);

        //Nhập số phần tử cho mỗi mảng 1 chiều trong mảng 2 chiều

        int elementsArray1;
        boolean isInvalidelEmentsArray1;
        System.out.println("Nhập số lượng phần tử cho mỗi mảng 1 chiều ");
        do {
            elementsArray1 = Integer.parseInt(scanner.nextLine());
            isInvalidelEmentsArray1 = elementsArray1 <= 0;
            if (isInvalidelEmentsArray1) {
                System.out.println("Số lượng phần tử trong mảng phải là số dương");
            }
        } while (isInvalidelEmentsArray1);

        //Khởi tạo mảng
        int[][] array = new int[elementsArray2][elementsArray1];
        int i;
        int j;
        for (i = 0; i < elementsArray2; i++) {
            for (j = 0; j < elementsArray1; j++) {
                System.out.printf("Nhập vào array[%d][%d] = ", i, j);
                array[i][j] = Integer.parseInt(scanner.nextLine());
            }
        }
        //Duyệt mảng
        int row = 0;
        int columns = 0;
        int max = array[0][0];
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
                if (max < array[i][j]) {
                    max = array[i][j];
                    row = i;
                    columns = j;
                }
            }
            System.out.println();
        }
        System.out.printf("Phần tử lớn nhất trong mảng 2 chiều là '%d'", max);
        System.out.println();
        System.out.printf("Vị trí của phần tử lớn nhất trong mảng là: array[%d][%d]", row, columns);
    }
}
