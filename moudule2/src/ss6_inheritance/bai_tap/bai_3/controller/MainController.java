package ss6_inheritance.bai_tap.bai_3.controller;

import ss6_inheritance.bai_tap.bai_3.model.MoveablePoint;
import ss6_inheritance.bai_tap.bai_3.model.Point;

public class MainController {
    public static void main(String[] args) {
        Point point = new Point(5, 8);
        System.out.println(point.toString());
        MoveablePoint moveablePoint = new MoveablePoint(2, 3, 4, 5);
        System.out.println(moveablePoint.toString());
        System.out.println(moveablePoint.move());
    }
}
