package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class DisplayGeometry {
    public static void main(String[] args) {
        int choice = -1;
        int lengthOfRectangle = -1;
        int widthOfRectangle = -1;
        int triangleSideBot = -1;
        int triangleSideTop = -1;

        Scanner scanner = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. In hình chữ nhật");
            System.out.println("2. In hình tam giác vuông có góc vuống ở cạnh dưới");
            System.out.println("3. In hình tam giác vuông có góc vuông ở cạnh trên");
            System.out.println("0. Exit");
            System.out.println("Lựa chọn của bạn là:");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    while (lengthOfRectangle <= 0 || widthOfRectangle <= 0) {
                        System.out.println("Nhập chiều dài hình chữ nhật");
                        lengthOfRectangle = scanner.nextInt();
                        System.out.println("Nhập chiều rộng hình chữ nhật");
                        widthOfRectangle = scanner.nextInt();
                    }
                    for (int i = 0; i < widthOfRectangle; i++) {
                        for (int j = 0; j < lengthOfRectangle; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;


                case 2:
                    while (triangleSideBot <= 0) {
                        System.out.println("Hãy nhập cạnh hình tam giác");
                        triangleSideBot = scanner.nextInt();
                    }
                    for (int i = 1; i <= triangleSideBot; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;


                case 3:
                    while (triangleSideTop <= 0) {
                        System.out.println("Hãy nhập cạnh hình tam giác");
                        triangleSideTop = scanner.nextInt();
                    }
                    for (int i = triangleSideTop; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.out.println("Cám ơn bạn đã sử dụng hệ thống");
                    System.exit(0);

                default:
                    System.out.println("Hãy nhập lại lựa chọn của bạn!");
            }
        }
    }
}
