package ss3_mang_va_phuong_thuc_trong_java.luyen_tap.demo_tham_tri_tham_chieu;

import java.util.Arrays;

public class Mang {
    public static void main(String[] args) {
        int[] array = new int[10];
        thayDoiMang1(array);
        System.out.println(Arrays.toString(array));
    }

    public static void thayDoiMang(int[] arr) {
        arr[1]=1;
        arr[0]=2;
    }
    public static void thayDoiMang1(int[]arr){
        int [] newArray = new int[3];
        arr=newArray;
        System.out.println(Arrays.toString(arr));
    }
}
