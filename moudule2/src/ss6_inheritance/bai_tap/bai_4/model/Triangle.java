package ss6_inheritance.bai_tap.bai_4.model;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;
    private double morePerimeter;

    public Triangle() {
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super.setColor(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.morePerimeter = 0.5 * (side1 + side2 + side3);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double getMorePerimeter() {
        return 0.5 * (this.side1 + this.side2 + this.side3);
    }

    public double getArea() {
        return Math.sqrt(this.morePerimeter * (this.morePerimeter - this.side1) * (this.morePerimeter - this.side2) * (this.morePerimeter - this.side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "color=" + super.getColor() +
                ", side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                '}';
    }
}
