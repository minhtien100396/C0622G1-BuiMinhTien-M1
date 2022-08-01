package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class FindGreatestCommonDivisor {
    public static void main(String[] args) {
        /*Trong toán học, nếu số nguyên a chia hết cho số nguyên b thì số b được gọi là ước của số
         nguyên a, a được gọi là bội của b. Số nguyên dương b lớn nhất là ước của cả hai số nguyên a, b
         được gọi là ước số chung lớn nhất (ƯCLN) của a và b.
         Trong trường hợp cả hai số nguyên a và b đều bằng 0 thì chúng không có ƯCLN vì
         khi đó mọi số tự nhiên khác không đều là ước chung của a
         và b.
         Nếu chỉ một trong hai số a hoặc b bằng 0, số kia khác 0 thì ƯCLN của chúng bằng giá trị
         tuyệt đối của số khác 0.

         Trong phần này, chúng ta sẽ phát triển một ứng dụng để tìm ước số chung lớn nhất của hai số.

         Ứng dụng cho phép nhập vào hai số nguyên và hiển thị ước số chung lớn nhất của hai số đó.*/


        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số nguyên thứ nhất");
        int firstInteger = scanner.nextInt();
        System.out.println("Nhập số nguyên thứ hai");
        int secondInteger = scanner.nextInt();
        int min = Math.min(firstInteger, secondInteger);
        int maxDivisor = 0;

        if (firstInteger == 0 && secondInteger == 0) {
            System.out.println("Không có ước chung lớn nhất!");
        } else if ((firstInteger == 0) && (secondInteger != 0)) {
            System.out.println("Ước chung lớn nhất = " + Math.abs(secondInteger));
        } else if ((firstInteger != 0) && (secondInteger == 0)) {
            System.out.println("Ước chung lớn nhất = " + Math.abs(firstInteger));
        } else if (firstInteger != secondInteger) {
            for (int i = 1; i <= min; i++) {
                if ((firstInteger % i == 0) && (secondInteger % i == 0)) {
                    maxDivisor = i;
                }
            }
            if (maxDivisor == 0) {
                System.out.println("Không có ước chung giữa " + firstInteger + " và " + secondInteger);
            } else {
                System.out.println("Ước chung lớn nhất giữa " + firstInteger + " và " + secondInteger + " là: " + maxDivisor);
            }
        }
    }
}
