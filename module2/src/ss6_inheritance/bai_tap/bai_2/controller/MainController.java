package ss6_inheritance.bai_tap.bai_2.controller;

import ss6_inheritance.bai_tap.bai_2.model.Point2D;
import ss6_inheritance.bai_tap.bai_2.model.Point3D;

public class MainController {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        point2D.setXY(1, 3);
        System.out.println(point2D.toString());
        Point3D point3D = new Point3D();
        point3D.setXY(30, 50);
        point3D.setZ(80);
        System.out.println(point3D.toString());
    }
}
