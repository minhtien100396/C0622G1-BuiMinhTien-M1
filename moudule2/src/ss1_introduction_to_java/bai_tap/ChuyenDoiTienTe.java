package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.println("Nhập số tiền USD cần đổi");
        float usd = new Scanner(System.in).nextFloat();
        final float tyGia = 22000f;
        float vnd = usd * tyGia;
        System.out.println("Số tiền vnd thu được sau khi đổi " + usd + "$ là: " + vnd + "VNĐ");
    }
}
