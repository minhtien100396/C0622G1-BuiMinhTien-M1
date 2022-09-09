package ss5_access_modifier_static_method_static_property.luyen_tap;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.setName("Đức");
        test.setAge(20);
        System.out.println(test.getName());
        System.out.println(test.getAge());
        System.out.println(test.getIsMale());
    }
}
