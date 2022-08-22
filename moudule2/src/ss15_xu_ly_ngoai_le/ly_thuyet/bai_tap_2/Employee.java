package ss15_xu_ly_ngoai_le.ly_thuyet.bai_tap_2;

import ss15_xu_ly_ngoai_le.bai_tap.IllegalTriangleException;

import java.io.IOException;

public class Employee extends User {


    public Employee(String tinNhan, int age) {
        super(tinNhan, age);
    }


    public static void main(String[] args) {
        User user = new Employee("Anh đẹp trai", 2);
        System.out.println(user.getAge());
        user.m1(2);
    }

    @Override
    public void m1(int age) {
        super.m1(age);
        m2();
    }

    public void m2() {
        throw new RuntimeException();
    }
}
