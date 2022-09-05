package case_study.task_1.utils;

import case_study.task_1.models.Employee;
import case_study.task_1.utils.validate.input_employee.InputIdEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputLevelOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputPositionOfEmployeeUltils;
import case_study.task_1.utils.validate.input_employee.InputSalaryOfEmployeeUltils;

import java.io.IOException;

public class InputEmployee extends InputPerson {
    static String idEmployee;
    static String level;
    static String position;
    static double salary;

    public static Employee inputEmployee() throws IOException {
        InputPerson.inputPerson();
        idEmployee = InputIdEmployeeUltils.inputIdEmployee();
        level = InputLevelOfEmployeeUltils.inputLevelOfEmployeeUltils();
        position = InputPositionOfEmployeeUltils.inputPositionOfEmployeeUltils();
        salary = InputSalaryOfEmployeeUltils.inputSalaryOfEmployeeUltils();
        Employee employee = new Employee(name, dateOfBirth, gender, idCard, phoneNumber, email, idEmployee,
                level, position, salary);
        return employee;
    }
}
