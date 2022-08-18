package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_noi_bot;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] array = {5, 7, 2, 1, 6, 0, -2, 9, 25, -10};
        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length ; j++) {
                if (arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

}
