package ss13_thuat_toan_tim_kiem.thuc_hanh.bai_1;

import java.util.Arrays;
import java.util.Scanner;

public class TimKiemNhiPhan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = khoiTaoMang();
        Arrays.sort(array);
        System.out.println("Mảng sau khi sắp xếp");
        System.out.println(Arrays.toString(array));
        System.out.println("Mời bạn nhập vào giá trị muốn tìm kiếm");
        int giaTri = Integer.parseInt(scanner.nextLine());
        int index = timKiem(array, giaTri, 0, array.length - 1);
        if (index == -1){
            System.out.println("Giá trị bạn nhập vào không tồn tại");
        }else {
            System.out.println("Giá trị bạn tìm kiếm nằm ở vị trị = " + index);
        }
    }

    public static int[] khoiTaoMang() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào số lượng phần tử cho mảng");
        int number = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.printf("Mời bạn nhập giá trị cho a[%d] = ", i);
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        return arr;
    }

    public static int timKiem(int[] arr, int giaTriTimKiem, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (giaTriTimKiem == arr[mid]) {
                return mid;
            } else if (giaTriTimKiem > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
