package ss1_introduction_to_java.luyen_tap;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner number =  new Scanner(System.in);
        System.out.println("Hãy nhập một số nguyên");
        int number1 = number.nextInt();
        System.out.println("Số nguyên bạn vừa nhập là: "+number1);
        System.out.println("Hãy nhập một số thực");
        float number2 = number.nextFloat();
        System.out.println("Số thực bạn vừa nhập là: "+number2);
        System.out.println("Hãy nhập một chuỗi");
        int number3 = number.nextInt();
        System.out.println("Chuỗi bạn vừa nhập là: "+number3);
    }
}
