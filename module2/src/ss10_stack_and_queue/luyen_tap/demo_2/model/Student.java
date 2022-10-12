package ss10_stack_and_queue.luyen_tap.demo_2.model;

public class Student {
    private int id;
    private String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Định nghĩa lại phương thức euqals
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        //Ép kiểu obj về student
        Student student = (Student) obj;
        if (this.id == student.id) {
            return true;
        }
        return false;
    }
}
