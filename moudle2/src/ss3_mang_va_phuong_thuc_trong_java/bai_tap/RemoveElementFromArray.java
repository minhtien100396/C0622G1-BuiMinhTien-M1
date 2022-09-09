package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {

        //Tạo mảng số nguyên gồm 10 phần tử cho trước
        int[] array = {10, 0, 10, 4, 10, 6, 8, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập phần tử cần xóa");
        int removeElement = Integer.parseInt(scanner.nextLine());
        int index;
        int i;
        int j;
        for (i = 0; i < array.length; i++) {
            if (removeElement == array[i]) {
                index = i;
                System.out.println(removeElement + " ở vị trí index = " + index);
            }
        }
        for (i = 0; i < array.length; i++) {
            if (removeElement == array[i]) {
                for (j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
