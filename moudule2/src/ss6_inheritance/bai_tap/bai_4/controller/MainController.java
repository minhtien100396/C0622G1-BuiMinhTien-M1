package ss6_inheritance.bai_tap.bai_4.controller;

import ss6_inheritance.bai_tap.bai_4.model.Triangle;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double getSide1;
        double getSide2;
        double getSide3;
        String color;
        System.out.println("Nhập màu cho tam giác");
        color = scanner.nextLine();
        boolean check;
        do {
            System.out.println("Nhập cạnh thứ nhất");
            getSide1 = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập cạnh thứ hai");
            getSide2 = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập cạnh thứ ba");
            getSide3 = Integer.parseInt(scanner.nextLine());
            check = (getSide1 + getSide2 < getSide3) || (getSide2 + getSide3 < getSide1) || (getSide1 + getSide3 < getSide2) ||
                    getSide1 <= 0 || getSide2 <= 0 || getSide3 <= 0;
            if (check) {
                System.out.println("Các cạnh bạn nhập vào không hợp lệ! (Tổng 2 cạnh phải lớn hơn cạnh còn lại)");
            }
        } while (check);

        Triangle triangle = new Triangle(color, getSide1, getSide2, getSide3);
        System.out.println(triangle.toString());
        System.out.printf("Chu vi hình tam giác là : %.2f", triangle.getPerimeter());
        System.out.println();
        System.out.printf("Diện tích hình tam giác là : %.2f", triangle.getArea());
    }
}
