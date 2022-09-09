package ss4_lop_va_doi_tuong_trong_java.bai_tap.xay_dung_lop_stop_watch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] arr = inputArray();
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("Thời gian bắt đầu: " + stopWatch.start());
        System.out.println("Mảng sau khi sắp xếp : " + Arrays.toString(sortArray(arr)));
        System.out.println("Thời gian kết thúc: " + stopWatch.stop());
        System.out.println("Thời gian thực thi: " + stopWatch.getElapsedTime());
    }

    //Khởi tạo và duyệt mảng
    public static int[] inputArray() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử cho mảng");
        do {
            number = Integer.parseInt(scanner.nextLine());
            if (number <= 0) {
                System.out.println("Số lượng phần tử trong mảng phải là số dương");
            }
        } while (number <= 0);

        int[] array = new int[number];
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * array.length + 1);
        }
        return array;
    }

    //Sắp xếp mảng
    public static int[] sortArray(int[] arr) {
        int i;
        int j;
        int temp;
        for (i = 0; i < arr.length; i++) {
            for (j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }
}
