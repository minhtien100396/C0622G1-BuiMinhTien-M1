package ss15_xu_ly_ngoai_le.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Mời bạn nhập x");
                int x = Integer.parseInt(scanner.nextLine());
                System.out.println("Mời bạn nhập y");
                int y = Integer.parseInt(scanner.nextLine());
                if (y == 0) {
                    throw new CalculationExampleException("Mẫu số không được bằng 0. Hãy nhập lại");
                }
                calc(x, y);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Giá trị bạn nhập không đúng, xin hãy nhập lại!");
            } catch (CalculationExampleException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void calc(int x, int y) {
        int a = x + y;
        int b = x - y;
        int c = x * y;
        int d = x / y;
        System.out.println("Tổng = " + a);
        System.out.println("Hiệu = " + b);
        System.out.println("Tích = " + c);
        System.out.println("Thương = " + d);
        System.out.println("Cám ơn bạn đã sử dụng phần mềm!!!");
    }
}
