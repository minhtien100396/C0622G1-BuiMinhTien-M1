package ss14_thuat_toan_sap_xep.ly_thuyet.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, -7, 4, 2, 1 - 6, 0, 15, -1, 7, -9, 3};
        int[] newArray = sortArray(array);
        System.out.println(Arrays.toString(newArray));
    }

    //Sắp xếp giảm dần
    public static int[] sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}

