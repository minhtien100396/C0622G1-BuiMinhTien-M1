package ss5_access_modifier_static_method_static_property.luyen_tap.static_property;

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
