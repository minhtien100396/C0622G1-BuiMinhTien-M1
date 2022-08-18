package ss14_thuat_toan_sap_xep.ly_thuyet.sort;

import java.util.Arrays;

public class InterchangerSortBST {
    public static void main(String[] args) {
        int[] array = {5, -7, 4, 2, 1 - 6, 0, 15, -1, 7, -9, 3};
        System.out.println(Arrays.toString(BinaryInsertion_Sort(array)));
    }

    //Sắp xếp tăng dần
    public static int[] BinaryInsertion_Sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int x = arr[i], left = 0, right = i - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (x < arr[mid]){
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--)
                arr[j + 1] = arr[j];
            arr[left] = x;
        }
        return arr;
    }
}
