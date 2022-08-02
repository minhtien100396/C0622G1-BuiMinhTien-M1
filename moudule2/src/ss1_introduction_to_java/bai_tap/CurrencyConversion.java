package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConversion {
    public static void main(String[] args) {
        System.out.println("Nhập số tiền USD cần đổi");
        Scanner scanner = new Scanner(System.in);
        double usd = Double.parseDouble(scanner.nextLine());
        double rate = 22000f;
        double vnd = usd * rate;
        System.out.println("Số tiền vnd thu được sau khi đổi " + usd + "$ là: " + vnd + "VNĐ");
    }
}
