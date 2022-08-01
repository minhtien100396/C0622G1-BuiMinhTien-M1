package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ShowGreetings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên của người dùng");
        String userName = scanner.nextLine();
        System.out.println("Hello " + userName);
    }
}
