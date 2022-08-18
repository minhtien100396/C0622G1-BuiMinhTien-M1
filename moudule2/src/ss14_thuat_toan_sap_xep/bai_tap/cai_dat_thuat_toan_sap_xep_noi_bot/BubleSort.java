package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_noi_bot;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] array = {5, 7, 9,10 };
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] arr) {
        boolean isSwap = true;
        for (int i = 0; i < arr.length - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}
