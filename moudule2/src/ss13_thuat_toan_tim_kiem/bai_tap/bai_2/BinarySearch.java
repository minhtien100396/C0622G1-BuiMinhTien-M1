package ss13_thuat_toan_tim_kiem.bai_tap.bai_2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử cho mảng");
        int numberElements = Integer.parseInt(scanner.nextLine());
        int[] array = new int[numberElements];
        for (int i = 0; i < numberElements; i++) {
            System.out.printf("Hãy nhập giá trị cho phần tử arr[%d] = ", i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu");
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {// 5 1 4 2 8 j=0 1 5 4 2 8 j=1 1 4 5 2 8
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi sắp xếp");
        System.out.println(Arrays.toString(array));
        System.out.println("Nhập giá trị của phần tử bạn muốn tìm kiếm trong mảng");
        int elementSearch = Integer.parseInt(scanner.nextLine());
        int binarySearch = binarySearch(array, 0, array.length - 1, elementSearch);
        if (binarySearch == -1) {
            System.out.println("Phần tử bạn cần tìm kiếm không có trong mảng");
        } else {
            System.out.println("Phần tử bạn cần tìm kiếm ở vị trí số " + binarySearch);
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        while (left <= right) {
            int mid = Math.round((left + right) / 2);
            if (array[mid] == value) {
                return mid;
            } else if (value > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
