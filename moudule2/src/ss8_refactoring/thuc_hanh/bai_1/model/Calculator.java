package ss8_refactoring.thuc_hanh.bai_1.model;

public class Calculator {
    public static int calculate(int firstOperand, int secondOperand , char operator) {
        final char ADDITION = '+';
        final char SUBTRACTION = '-';
        final char MULTIPLICATION = '*';
        final char DIVISION = '/';
        switch (operator) {
            case ADDITION:
                return firstOperand + firstOperand;
            case SUBTRACTION:
                return firstOperand - firstOperand;
            case MULTIPLICATION:
                return firstOperand * firstOperand;
            case DIVISION:
                if (firstOperand != 0)
                    return firstOperand / firstOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
