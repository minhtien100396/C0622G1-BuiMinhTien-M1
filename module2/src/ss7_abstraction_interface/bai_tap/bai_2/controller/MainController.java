package ss7_abstraction_interface.bai_tap.bai_2.controller;

import ss7_abstraction_interface.bai_tap.bai_2.model.*;

public class MainController {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Rectangle(3, 5);
        shapes[2] = new Square(9);
        for (Shape elements : shapes) {
            if (elements instanceof Colorable) {
                ((Colorable) elements).howtoColor();
            }
            System.out.println(elements.getArea());
        }
    }
}
