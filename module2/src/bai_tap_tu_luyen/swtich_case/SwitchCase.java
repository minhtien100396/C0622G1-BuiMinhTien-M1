package bai_tap_tu_luyen.swtich_case;

import java.util.Scanner;

public class SwitchCase {
    public static void thucHienPhepTinh(double a, double b, char toanHang) {
        switch (toanHang) {
            case '+':
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case '-':
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case '*':
                System.out.println(a + " x " + b + " = " + (a * b));
                break;
            case '/':
                System.out.println(a + " / " + b + " = " + (a / b));
                break;
            default:
                System.out.println("Bạn đã nhập sai toán hạng");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String check;
        char toanHang;
        double a;
        double b;
        do {
            System.out.println("Nhập số a");
            a = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập số b");
            do {
                b = Double.parseDouble(scanner.nextLine());
                if (b == 0) {
                    System.out.println("Mẫu số không thể bằng 0. Hãy nhập lại");
                }
            } while (b == 0);
            System.out.println("Nhập toán hạng");
            toanHang = scanner.nextLine().charAt(0);
            thucHienPhepTinh(a, b, toanHang);
            System.out.println("Bấm nút y nếu muốn tiếp tục\nBấm nút n nếu muốn dừng lại");
            check = scanner.nextLine();
            if (check.equalsIgnoreCase("n")) {
                break;
            }
        } while (true);
        System.out.println("Cám ơn bạn đã dùng phần mềm");
    }
}
