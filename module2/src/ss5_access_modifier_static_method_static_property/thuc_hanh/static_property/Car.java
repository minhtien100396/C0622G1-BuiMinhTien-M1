package ss5_access_modifier_static_method_static_property.thuc_hanh.static_property;

public class Car {
    private String name;
    private String engine;

    // Khai báo thuộc tính numberOfCars.
    public static int numberOfCars;

    public Car(){
        numberOfCars++;
    }
}