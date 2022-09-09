package ss6_inheritance.luyen_tap.demo;

public class Animal {
    String name = "Sư tử";

    public Animal(String name) {
        this.name = name;
    }
    public void m1() {
        System.out.println("abc");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
