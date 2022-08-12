package ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_1.model;

public class Student extends Person {
    private double point;
    private String nameClass;

    public Student(int id, String name, String dateOfBirth, double point, String nameClass) {
        super(id, name, dateOfBirth);
        this.point = point;
        this.nameClass = nameClass;
    }

    public Student() {
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "point=" + point +
                ", nameClass='" + nameClass + '\'' +
                '}';
    }
}
