package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;

public class InvertTheElements {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 0, 4, 5, 6, 7, 8};

        for (int i = 0; i < (arr.length) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
