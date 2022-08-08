package ss6_inheritance.bai_tap.bai_1.controller;

import ss6_inheritance.bai_tap.bai_1.model.Circle;
import ss6_inheritance.bai_tap.bai_1.model.Cylinder;

public class MainController {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(10);
        System.out.println(circle.toString());
        System.out.printf("Diện tích hình tròn :%.2f", circle.area());
        System.out.println();
        Cylinder cylinder = new Cylinder();
        cylinder.setRadius(100);
        System.out.println(cylinder.toString());
        System.out.printf("Thể tích hình trụ :%.2f", cylinder.volume());
    }
}
