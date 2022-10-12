package bean;

import exception.ArithmeticException;

import java.math.BigDecimal;

public class Calculator {
    public static BigDecimal calculate(double firstOperand, double secondOperand, char operator) {
        switch (operator) {
            case '+':
                return new BigDecimal(firstOperand + secondOperand);
            case '-':
                return new BigDecimal(firstOperand - secondOperand);
            case 'x':
                return new BigDecimal(firstOperand * secondOperand);
            case '/':
                try {
                    if (secondOperand != 0) {
                        return new BigDecimal(firstOperand / secondOperand);
                    } else {
                        throw new ArithmeticException("Mẫu số không thể bằng 0");
                    }
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            default:
                throw new RuntimeException("Error");
        }
    }
}
