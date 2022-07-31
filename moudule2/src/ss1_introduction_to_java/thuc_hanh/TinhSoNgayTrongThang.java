package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        //Tạo đối tượng Scacnner riêng
        System.out.println("Nhập tháng bạn cần kiểm tra");
        int thang = new Scanner(System.in).nextInt();
        switch (thang) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                System.out.println("Tháng " + thang + " có 31 ngày");
            }
            break;
            case 2: {
                System.out.println("Tháng " + thang + " có 28 ngày hoặc 29 ngày");
            }
            break;
            case 4:
            case 6:
            case 9:
            case 11: {
                System.out.println("Tháng " + thang + " có 30 ngày");
            }
            break;
            default: {
                System.out.println("Vui lòng nhập lại tháng cần kiểm tra (tháng >0 và tháng < 13)");
            }
        }
    }
}
