package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.println("Nhập số tiền USD cần đổi");
        int usd = new Scanner(System.in).nextInt();
        int vnd = usd * 22000;
        System.out.println("Số tiền vnd thu được sau khi đổi " + usd + "$ là: " + vnd + "VNĐ");
    }
}
