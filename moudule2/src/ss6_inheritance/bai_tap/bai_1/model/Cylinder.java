package ss6_inheritance.bai_tap.bai_1.model;

public class Cylinder extends Circle {
    private double height = 5;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double volume() {
        return Math.PI * (Math.pow(super.getRadius(), 2)) * height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + super.getRadius() +
                ", color=" + super.getColor() +
                ", height=" + height +
                '}';
    }
}
