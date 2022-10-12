package ss14_thuat_toan_sap_xep.bai_tap.cai_dat_thuat_toan_sap_xep_chen;

public class SetupInsertionSort {
    public static int[] insertionSort(int[] arr) {
        //Vòng for
//        for (int i = 1; i < arr.length; i++) {
//            int key = arr[i];
//            int j;
//            for (j = i - 1; j >= 0 && arr[j] > arr[i]; j--) {
//                arr[j + 1] = arr[j];
//            }
//            arr[j + 1] = key;
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
