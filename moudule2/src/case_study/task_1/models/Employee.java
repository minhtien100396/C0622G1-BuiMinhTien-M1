package case_study.task_1.models;

public class Employee extends Person {
    private String IdEmployee;
    private String level;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String name, String dateOfBirth, boolean gender, long idNumber, String phoneNumber, String email, String idEmployee, String level, String position, double salary) {
        super(name, dateOfBirth, gender, idNumber, phoneNumber, email);
        IdEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String idEmployee, String level, String position, double salary) {
        IdEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        IdEmployee = idEmployee;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "IdEmployee='" + IdEmployee + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
