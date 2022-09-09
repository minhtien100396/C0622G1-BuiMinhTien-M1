package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_chon;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {5, 7, 2, 1, 6, 0, -2, 9, 25, -10};
        System.out.println(Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] arr) {
        //Vòng for
//        for (int i = 0; i < arr.length - 1; i++) {
//            int min = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] < arr[min]) {
//                    min = j;
//                }
//            }
//            int temp = arr[min];
//            arr[min] = arr[i];
//            arr[i] = temp;
//        }

        //Vòng while
        for (int i = 1; i < arr.length ; i++) {
            int key = arr[i];
            int minPos = i-1;
            while (minPos>=0 && arr[minPos]> key){
                arr[minPos+1] = arr[minPos];
                minPos--;
            }
            arr[minPos+1] = key;
        }
        return arr;
    }
}
