package ss10_stack_and_queue.luyen_tap.demo_2.controller;

import ss10_stack_and_queue.luyen_tap.demo_2.model.Student;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1,"Tiến");
        Student student2 = new Student(1, "Tiến");
        System.out.println(student1.equals(student2));
    }
}
