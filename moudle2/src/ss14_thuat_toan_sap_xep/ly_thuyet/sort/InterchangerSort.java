package ss14_thuat_toan_sap_xep.ly_thuyet.sort;

import java.util.Arrays;

public class InterchangerSort {
    public static void main(String[] args) {
        int[] array = {-1, 150, 190, 170, -1, -1, 180, 160};
        System.out.println(Arrays.toString(sortArray(array)));
    }

    //Sắp xếp tăng dần
//    public static int[] sortArray(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i+1; j < arr.length; j++) {
//                if (arr[i] > arr[j]) {
//                    int temp = arr[j];
//                    arr[j] = arr[i];
//                    arr[i] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    //Sắp xếp giảm dần
    public static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
