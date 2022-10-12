package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        String[] arr = new String[]{"Anh", "Ngoc", "Thao"};
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên sinh viên muốn tìm");
        String name = scanner.nextLine();
        System.out.println(name);
        boolean isName = false;
        for (int i = 0; i < arr.length; i++) {
            if (name.equals(arr[i])) {
                System.out.println("Sinh viên cần tìm tên là: " + arr[i] + " ở vị trí index = " + i);
                isName = true;
                break;
            }
        }
        if (!isName) {
            System.out.println("Không tìm thấy sinh viên tên " + name);
        }
    }
}
