package ss8_refactoring.thuc_hanh.bai_2.model;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean izBuzz = number % 5 == 0;
        if (isFizz && izBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (izBuzz)
            return "Buzz";

        return number + "";
    }
}
