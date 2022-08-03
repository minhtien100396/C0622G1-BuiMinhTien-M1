package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class NumberOfOccurrencesOfTheCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi bất kì");
        String chain = scanner.nextLine();
        System.out.println("Nhập vào bàn phím kí tự bạn cần kiểm tra");
        char oneChar = scanner.next().charAt(0);
        System.out.printf("Chuỗi bạn vừa nhập là : '%s'", chain);
        int count = 0;
        int i;
        for (i = 0; i < chain.length(); i++) {
            if (oneChar == chain.charAt(i)) {
                count++;
            }
        }
        System.out.println();
        System.out.printf("Số lần xuất hiện của kí tự '%c' là '%d'", oneChar, count);
    }
}
