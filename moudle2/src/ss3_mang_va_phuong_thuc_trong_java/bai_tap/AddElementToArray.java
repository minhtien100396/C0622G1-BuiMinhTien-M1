package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Nhập số lượng phần tử cho mảng
        int number;
        do {
            System.out.println("Nhập số lượng phần tử cho mảng");
            number = Integer.parseInt(scanner.nextLine());
            if (number < 0) {
                System.out.println("Vui lòng nhập lại. Số lượng phần tử trong mảng không thể là số âm");
            }
        } while (number < 0);
        //Khởi tạo mảng không chứa giá trị
        int[] arr = new int[number];
        //Gán giá trị cho phần tử của mảng
        int i;
        for (i = 0; i < number; i++) {
            System.out.printf("Nhập vào arr[%d] = ", i);
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        //nhập số cần chèn vào mảng
        System.out.println("Nhập số cần chèn vào mảng");
        int numberInserted = Integer.parseInt(scanner.nextLine());
        //Nhập vị trí muốn thêm vào, kiểm tra điều kiện vị trí
        int index;
        do {
            System.out.println("Nhập vị trí muốn thêm vào mảng");
            index = Integer.parseInt(scanner.nextLine());
            if (index < -1 || index > (arr.length - 1)) {
                System.out.println("Không chèn được phần tử vào mảng. Vui lòng nhập lại vị trí cần chèn");
            }
        } while (index < -1 || index > (arr.length - 1));

        //Duyệt mảng

        for (i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = numberInserted;

        System.out.print(Arrays.toString(arr));
    }
}
