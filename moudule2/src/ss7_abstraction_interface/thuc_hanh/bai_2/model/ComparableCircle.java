package ss7_abstraction_interface.thuc_hanh.bai_2.model;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    @Override
    public int compareTo(ComparableCircle circle) {
        if (getRadius() >= circle.getRadius()) {
            return 1;
        }
        return -1;
    }

    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
}
