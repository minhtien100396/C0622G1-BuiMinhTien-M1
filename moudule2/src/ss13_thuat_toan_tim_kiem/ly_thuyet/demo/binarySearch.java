package ss13_thuat_toan_tim_kiem.ly_thuyet.demo;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {9, 8, 5, 2, 1, 0, -2, 6, 7, 12, 8, 9};
        //B1: Sắp xếp các phần tử của mảng theo thứ tự tăng dần
        //C1: Dùng Arrays
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(timKiemPhanTu(arr, 0));
    }

    public static int timKiemPhanTu(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
