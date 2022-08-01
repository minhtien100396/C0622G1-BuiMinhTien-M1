package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class CalculateLoanInterest {
    public static void main(String[] args) {
        /*Ứng dụng cho phép nhập vào 3 tham số: số lượng tiền cho vay, tỉ lệ lãi suất theo tháng,
        số tháng cho vay. Ứng dụng sẽ hiển thị tổng số tiền có được khi hết thời hạn cho vay.
        Số_tiền_lãi = Số_tiền_gửi *  tỉ_lệ_lãi_suất (% năm) / 12 * số_tháng_gửi
*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền bạn muốn gửi");
        double monney = scanner.nextDouble();
        System.out.println("Nhập lãi suất theo năm");
        double rate = scanner.nextDouble();
        System.out.println("Nhập số tháng muốn gửi");
        int month = scanner.nextInt();
        double result = 0;
        if (monney <= 0 || rate <= 0 || month <= 0 || month > 12) {
            System.out.println("Giá trị bạn nhập vào không hợp lệ!");
        } else {
            for (int i = 1; i <= month; i++) {
                result += monney * (((rate / 100) / 12) * 3);
            }
            System.out.println("Tiền lãi = " + result);
        }
    }
}
