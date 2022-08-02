package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int [] firstArr = {1,2,3,4,5};
        int [] secondArr = {6,7,8};
        System.out.println(firstArr.length);
        int [] thirdArr = new int [firstArr.length+secondArr.length];
        System.out.println(thirdArr.length);
        for (int i = 0; i < firstArr.length ; i++) {
            firstArr[i]=thirdArr[i];
        }
        //System.out.println(Arrays.toString(thirdArr));
    }
}
