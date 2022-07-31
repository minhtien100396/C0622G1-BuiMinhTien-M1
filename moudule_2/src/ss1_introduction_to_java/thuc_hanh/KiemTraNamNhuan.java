package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class KiemTraNamNhuan {
    public static void main(String[] args) {
        /*Ứng dụng cho phép người dùng nhập vào một năm, sau đó sẽ đưa ra thông báo là năm đó là
        năm nhuận hay không phải là năm nhuận.

        Những năm chia hết cho 4 mà không chia hết cho 100 là năm nhuận

        Những năm chia hết đồng thời cho 100 và 400 là năm nhuận
        */

        System.out.println("Nhập vào một năm bất kì");
        int nam = new Scanner(System.in).nextInt();
        if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 100 == 0 && nam % 400 == 0)) {
            System.out.println("Năm " + nam + " là năm nhuận");
        } else {
            System.out.println("Năm " + nam + " không phải là năm nhuận");
        }
    }
}
