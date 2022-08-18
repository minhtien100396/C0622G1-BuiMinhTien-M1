package ss14_thuat_toan_sap_xep.ly_thuyet.sort;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] array = {5, -7, 4, 2, 1 - 6, 0, 15, -1, 7, -9, 3};
        System.out.println(Arrays.toString(sortArray(array)));
    }
    //Sắp xếp theo thứ tự giảm dần C1:
//    public static int[] sortArray(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] < arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    //Sắp xếp theo thứ tự giảm dần C2:
//    public static int[] sortArray(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = arr.length - 1; j > i; j--) {
//                if (arr[j] > arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    //Sắp xếp theo thứ tự tăng dần C1:
//    public static int[] sortArray(int[] arr) {
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = arr.length - 1; j > i; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j - 1];
//                    arr[j - 1] = temp;
//                }
//            }
//        }
//        return arr;
//    }

    //Sắp xếp theo thứ tự tăng dần C1:
    public static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
