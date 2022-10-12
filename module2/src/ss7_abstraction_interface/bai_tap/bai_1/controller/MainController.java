package ss7_abstraction_interface.bai_tap.bai_1.controller;

import ss7_abstraction_interface.bai_tap.bai_1.model.Circle;
import ss7_abstraction_interface.bai_tap.bai_1.model.Rectangle;
import ss7_abstraction_interface.bai_tap.bai_1.model.Shape;
import ss7_abstraction_interface.bai_tap.bai_1.model.Square;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(5);
        shapes[2] = new Rectangle(3, 6);
        for (Shape shape : shapes) {
            System.out.printf("Diện tích trước khi thay đổi kích thước là: %.2f", shape.getArea());
            System.out.println();
            shape.resize(Math.round(Math.random() * 100 + 1));
        }
        for (Shape shape : shapes) {
            System.out.printf("Diện tích sau khi thay đổi kích thước là: %.2f", shape.getArea());
            System.out.println();
        }
    }
}

