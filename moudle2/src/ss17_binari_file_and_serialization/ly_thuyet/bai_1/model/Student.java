package ss17_binari_file_and_serialization.ly_thuyet.bai_1.model;

import java.io.Serializable;

public class Student extends Person {
    private double point;
    //Có transient thì không chuyển đổi kiểu
    private  String className;

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
        return "Student{" +
                super.toString() +
                "point=" + point +
                ", className='" + className + '\'' +
                '}';
       // return String.format("%s,%s,%s,%s,%s,%s",this.getId(),this.getName(),this.getDateOfBirth(), this.getGender(),point,className);
    }
}
