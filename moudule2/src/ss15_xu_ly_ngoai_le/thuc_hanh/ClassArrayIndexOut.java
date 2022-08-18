package ss15_xu_ly_ngoai_le.thuc_hanh;

import java.util.Scanner;

public class ClassArrayIndexOut {
    public static void main(String[] args) {
        int[] arr = randomArray();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập vào index");
        boolean check = true;
        while (check) {
            check = false;
            try {
                int index = Integer.parseInt(scanner.nextLine());
                System.out.println("Giá trị của phần tử ở vị trí " + index + " là: " + arr[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Mày nhập ngáo à. Mảng chỉ có 100 phần tử thôi");
                check = true;
                System.out.println("Nhập lại đi mày");
            } catch (NumberFormatException e) {
                System.out.println("Mày ngáo chưa. Nhập chữ làm gì?");
                check = true;
                System.out.println("Nhập lại đi mày");
            }
        }
        System.out.println("Cám ơn mày đã tha cho tau");
    }

    public static int[] randomArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random() * 100 + 1);
            System.out.printf(arr[i] + " ");
        }
        return arr;
    }
}
