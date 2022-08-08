package ss6_inheritance.thuc_hanh;

public class Child extends Parent {
    int age;

    public Child() {
    super();
    }

    public Child(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
