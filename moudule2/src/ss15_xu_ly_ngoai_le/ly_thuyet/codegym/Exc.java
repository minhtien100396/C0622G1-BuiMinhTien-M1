package ss15_xu_ly_ngoai_le.ly_thuyet.codegym;

public class Exc extends Exception {
    public static int age;
    public Exc() {
    }

    public Exc(String message) {
        super(message);
    }

    public int getAge() {
        return age;
    }
}
