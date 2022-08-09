package ss7_abstraction_interface.luyen_tap.demo.controller;

abstract class Animal {
    int id;
    String name;
    byte gender;
    float age;

    abstract void move();

    void inputInfo() {

    }
}

class Cat2 extends Animal {

    @Override
    void move() {
        System.out.println("Run");
    }
}

public class MainController {
    public static void main(String[] args) {

    }
}
