package bai_tap_tu_luyen.ve_hinh;

import java.util.Scanner;

public class TamGiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Hình 1");
            System.out.println("2. Hình 2");
            System.out.println("3. Hình 3");
            System.out.println("4. Hình 4");
            System.out.println("5. Hình 5");
            System.out.println("0. Exit");
            System.out.println("Hãy chọn");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 0) {
                break;
            }
            int n;
            System.out.println("Hãy nhập n");
            do {
                n = Integer.parseInt(scanner.nextLine());
                if (n<=0){
                    System.out.println("n phải là số nguyên dương");
                }
            } while (n <= 0);
            switch (choice) {
                case 1:
                    hinh1(n);
                    break;
                case 2:
                    hinh2(n);
                    break;
                case 3:
                    hinh3(n);
                    break;
                case 4:
                    hinh4(n);
                    break;
                case 5:
                    hinh5(n);
                    break;
            }
            System.out.println("Bấm Y để tiếp tục\nBấm N để dừng lại");
            String check = scanner.nextLine();
            if (check.equalsIgnoreCase("n")){
                break;
            }
        }
        System.out.println("Cám ơn bạn đã sử dụng phần mềm");
    }

    public static void hinh1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void hinh2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void hinh3(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void hinh4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void hinh5(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + i == n - 1 || j == n / 2 || (i == 0 && j >= n / 2) || (i == n - 1 && j <= n / 2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
