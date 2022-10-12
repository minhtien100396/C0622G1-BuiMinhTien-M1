package ss14_thuat_toan_sap_xep.thuc_hanh;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] arr = {1, 6, -2, 5, 1, 3, -76, 65, 4, 99};
        System.out.println(Arrays.toString(selectionSort(arr)));
    }


    public static int[] bubleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int pos = i - 1;
            while (pos >= 0 && arr[pos] > key) {
                arr[pos + 1] = arr[pos];
                pos--;
            }
            arr[pos + 1] = key;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
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
