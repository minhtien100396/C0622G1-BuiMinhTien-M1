package ss5_access_modifier_static_method_static_property.thuc_hanh.static_property;

import ss5_access_modifier_static_method_static_property.thuc_hanh.static_property.Car;

public class TestStaticProperty {
    public static void main(String[] args) {
        new Car();
        System.out.println(Car.numberOfCars);
        new Car();
        System.out.println(Car.numberOfCars);
        new Car();
        System.out.println(Car.numberOfCars);

    }
}
