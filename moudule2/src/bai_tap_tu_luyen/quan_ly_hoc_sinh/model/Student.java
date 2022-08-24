package bai_tap_tu_luyen.quan_ly_hoc_sinh.model;

public class Student extends Person {
    private double point;
    private String className;

    public Student() {
    }

    public Student(double point, String className) {
        this.point = point;
        this.className = className;
    }

    public Student(int id, String name, String dateOfBirth, String gender, double point, String className) {
        super(id, name, dateOfBirth, gender);
        this.point = point;
        this.className = className;
    }


    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
//        return "Student{" +
//                super.toString() +
//                "point=" + point +
//                ", className='" + className + '\'' +
//                '}';
        return String.format("%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getDateOfBirth(), this.getGender(),point,className);
    }
}
