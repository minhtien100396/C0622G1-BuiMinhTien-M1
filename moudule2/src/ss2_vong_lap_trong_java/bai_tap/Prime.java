package ss2_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        /*Bước 1: Khai báo biến số nguyên numbers và nhập cho nó một giá trị từ bàn phím để lưu số
         lượng số nguyên tố cần in ra.

        Bước 2: Khai báo biến count và gán cho nó giá trị 0, biến này để đếm xem số lượng lượng số
        nguyên tố cần in ra đã bằng numbers hay chưa.

        Bước 3: Khai báo biến N và gán cho giá trị 2, biến này để kiểm tra xem các giá trị nó nhận
        được có phải là số nguyên tố không, mỗi lần lặp giá trị của biến sẽ được tăng lên 1.

        Bước 4: Trong khi count < numbers thì:

         Kiểm tra xem N có phải là số nguyên tố không. Nếu N là số nguyên tố thì in ra giá trị của N và tăng
        giá trị của count lên 1
        Giá trị của N tăng lên 1 để kiểm tra số tiếp theo*/


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập giá trị giới hạn hiển thị");
        int number = scanner.nextInt();
        int check = 1;
        System.out.println("Hiển thị 20 chữ số nguyên tố đầu tiên");
        for (int i = 2; i < number; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(i);
                check++;
            }
            if (check > 20) {
                break;
            }
        }

    }
}
