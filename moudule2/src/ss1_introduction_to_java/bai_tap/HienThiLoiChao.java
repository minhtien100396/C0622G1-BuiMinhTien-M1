package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        Scanner loiChao = new Scanner(System.in);
        System.out.println("Nhập tên của người dùng");
        String tenNguoiDung = loiChao.nextLine();
        System.out.println("Hello " + tenNguoiDung);
    }
}
