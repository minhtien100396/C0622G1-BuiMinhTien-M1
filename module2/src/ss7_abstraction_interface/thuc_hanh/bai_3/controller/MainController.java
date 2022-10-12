package ss7_abstraction_interface.thuc_hanh.bai_3.controller;

import ss7_abstraction_interface.thuc_hanh.bai_3.model.Circle;
import ss7_abstraction_interface.thuc_hanh.bai_3.model.CircleComparator;

import java.util.Arrays;

public class MainController {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        CircleComparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}