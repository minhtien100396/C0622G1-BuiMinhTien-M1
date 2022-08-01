package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class MenuDesignForApp {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Vẽ hình tam giác");
            System.out.println("2. Vẽ hình vuông");
            System.out.println("3. Vẽ hình chữ nhật");
            System.out.println("0. Exit");
            System.out.println("Nhập lựa chọn của bạn");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("******");
                    System.out.println("*****");
                    System.out.println("****");
                    System.out.println("***");
                    System.out.println("**");
                    System.out.println("*");
                    break;
                case 2:
                    System.out.println("******");
                    System.out.println("******");
                    System.out.println("******");
                    break;
                case 3:
                    System.out.println("**********************");
                    System.out.println("**********************");
                    System.out.println("**********************");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Hãy nhập lại lựa chọn trong Menu");
            }
        }
    }
}
