package case_study.task_1.models;

import java.time.LocalDate;

public class Employee extends Person {
    private String idEmployee;
    private String level;
    private String position;
    private double salary;


    public Employee() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getDateOfBirth(), this.getGender(), this.getIdCard(), this.getPhoneNumber(),
                this.getEmail(), idEmployee, level, position, salary);
    }

    public Employee(String name, LocalDate dateOfBirth, String gender, String idCard, String phoneNumber,
                    String email, String idEmployee, String level, String position, double salary) {
        super(name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.idEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }


    public Employee(String idEmployee, String level, String position, double salary) {
        this.idEmployee = idEmployee;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
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
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getDateOfBirth(), this.getGender(), this.getIdCard(), this.getPhoneNumber(),
                this.getEmail(), idEmployee, level, position, salary);
    }
}
