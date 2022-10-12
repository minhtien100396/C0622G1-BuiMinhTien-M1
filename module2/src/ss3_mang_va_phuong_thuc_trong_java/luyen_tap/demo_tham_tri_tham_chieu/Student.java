package ss3_mang_va_phuong_thuc_trong_java.luyen_tap.demo_tham_tri_tham_chieu;

public class Student {
    public String name;
    public int age;

    //construct

    public Student(String name, int age){
        this.name = name; //Gán giá trị name cho thuộc tính name của đối tượng Student
        this.age = age; //Gán giá trị tuổi cho thuộc tính tuổi của đối tương Student
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
