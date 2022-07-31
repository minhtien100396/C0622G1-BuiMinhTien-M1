package ss1_introduction_to_java.luyen_tap;

import java.util.Scanner;

public class KiemTra {
    public static void main(String[] args) {
        // Nhập vào một số từ bàn phím kiểm tra xem số đó có phải là số chẵn hay không?

        System.out.println("Nhập vào một tháng bất kì");
        int thang = new Scanner(System.in).nextInt();
        switch (thang){
            case 1:
            case 3:
            case 5:
            case 9:
            case 11: {
                System.out.println("Tháng "+thang+" có 31 ngày");
                break;
            }
            case 4:
            case 6:
            case 8:
            case 10:
            case 12: {
                System.out.println("Tháng "+thang+" có 30 ngày");
                break;
            }
            case 2:{
                System.out.println("Tháng "+thang+" có 28 ngày");
                break;
            }
            default:{
                System.out.println("Vui lòng nhập lại tháng (tháng >0 và tháng <13)");
            }
        }
    }
}
