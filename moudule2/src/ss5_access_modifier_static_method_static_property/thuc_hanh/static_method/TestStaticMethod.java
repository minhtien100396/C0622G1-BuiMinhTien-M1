package ss5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        System.out.println(Student.truongHoc);
        Student student1 = new Student(111, "Tiến");
        Student student2 = new Student(111, "Giang");
        Student student3 = new Student(111, "Châu");
        student1.display("Vinh Ninh");
        student2.hienThi();
        student3.hienThi();
    }
}
