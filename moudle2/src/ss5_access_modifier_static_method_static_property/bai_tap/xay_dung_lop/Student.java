package ss5_access_modifier_static_method_static_property.bai_tap.xay_dung_lop;

public class Student {
    private String name = "John";
    private String className = "C02";

    public Student() {
    }

    //set
    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
