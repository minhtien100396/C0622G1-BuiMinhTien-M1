package ss7_abstraction_interface.thuc_hanh.bai_3.model;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle circle1, Circle circle2) {
        if (circle1.getRadius()>=circle2.getRadius()){
            return 1;
        }
        return -1;
    }
}
