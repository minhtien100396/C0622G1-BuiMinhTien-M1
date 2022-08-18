package ss15_xu_ly_ngoai_le.ly_thuyet.codegym;

import java.util.Scanner;

public class Main extends Exc {
    public static void main(String[] args) {
        try {
            age = m1();
        } catch (Exc exc) {
            exc.printStackTrace();
        }
    }

    public static int m1() throws Exc {
        Scanner scanner = new Scanner(System.in);
//        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Nhập vào index");
//        try {
            int number = Integer.parseInt(scanner.nextLine());
          //System.out.println(arr[number]);
        if (number<0){
            throw new Exc("Tuổi em nhỏ quá");
        }else if (number>100){
            throw new Exc("Tuổi em ảo thế");
        }
        return number;
//        } catch (NumberFormatException e) {
//            System.out.println("Mày ngáo à! Nhập vào số đi");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Mày nhập index ngáo à");
//        }finally {
//            System.out.println("chạy đi mày");
//        }
    }
}
