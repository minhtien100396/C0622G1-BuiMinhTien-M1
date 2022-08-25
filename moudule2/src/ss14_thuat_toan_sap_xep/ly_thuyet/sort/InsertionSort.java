package ss14_thuat_toan_sap_xep.ly_thuyet.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {-1, 150, 190, 170, -1, -1, 180, 160};
        System.out.println(Arrays.toString(sortArray(array)));
    }

    //Sắp xếp tăng dần
//    public static int[] sortArray(int[] arr) {
//        for (int i = 1; i < arr.length; i++) {
//            //Tạo biến x để lưu giá trị phần tử muốn chèn vào đoạn con
//            int x = arr[i];
//            //Tạo biến pos để lấy vị trí phần tử cuối cùng của đoạn con
//            int pos = i - 1;
//
//            while (pos >= 0 && arr[pos] > x) {
//                arr[pos + 1] = arr[pos];
//                pos--;
//            }
//            //Đến khi nào pos<0 or pos <x thì dừng vòng lặp while và điền giá trị của x trước arr[pos]
//            arr[pos + 1] = x;
//        }
//        return arr;
//    }

    //Sắp xếp giảm dần
    public static int[] sortArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //Tạo biến x để lưu giá trị phần tử muốn chèn vào đoạn con
            int x = arr[i];
            //Tạo biến pos để lấy vị trí phần tử cuối cùng của đoạn con
            int pos = i - 1;

            while (pos >= 0 && arr[pos] > x) {
                arr[pos + 1] = arr[pos];
                pos--;
            }
            //Đến khi nào pos<0 or pos <x thì dừng vòng lặp while và điền giá trị của x trước arr[pos]
            arr[pos + 1] = x;
        }
        return arr;
    }
}

