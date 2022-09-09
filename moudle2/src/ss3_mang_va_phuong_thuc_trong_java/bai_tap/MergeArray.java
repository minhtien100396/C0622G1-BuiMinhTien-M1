package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] firstArr = {1, 2, 3, 4, 5};
        int[] secondArr = {6, 7, 8, 5, 2, 1, 1, 2, 4, 5};
        int[] thirdArr = new int[firstArr.length + secondArr.length];
        int i;
        for (i = 0; i < firstArr.length; i++) {
            thirdArr[i] = firstArr[i];
        }
        for (i = 0; i < secondArr.length; i++) {
            thirdArr[firstArr.length + i] = secondArr[i];
        }
        System.out.println(Arrays.toString(thirdArr));
    }
}
