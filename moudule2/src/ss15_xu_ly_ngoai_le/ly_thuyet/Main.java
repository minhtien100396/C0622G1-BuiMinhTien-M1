package ss15_xu_ly_ngoai_le.ly_thuyet;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Xử lý tại chỗ
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("mời bạn nhập vào");
//            int a = scanner.nextInt();
//            System.out.println(a);
//        } catch (InputMismatchException e) {
//            System.out.println("Giá trị bạn nhập vào không hợp lệ");
//        } catch (Exception e){
//            System.out.println("Lỗi exception");
//        }
        User user = new User();
    }
    //Lan truyền exception


    public static int inputNumber() throws IOException {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("mời bạn nhập vào");
            int a = scanner.nextInt();
            return a;
        } catch (InputMismatchException e) {
            System.out.println("Giá trị bạn nhập vào không hợp lệ");
        } catch (Exception e){
            System.out.println("Lỗi exception");
        }
        return 0;
    }
}
