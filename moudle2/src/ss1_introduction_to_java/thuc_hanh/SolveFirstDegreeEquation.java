package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class SolveFirstDegreeEquation {
    public static void main(String[] args) {
        /*Giải phương trình bậc nhất ax+b=0;
        Nếu b=0 và a =0 => Phương trình vô số nghiệm.
        Nếu b=0 và a!=0 => Phương trình có 1 nghiệm duy nhất x =0;
        Nếu b!=0 và a =0 => Phương trình vô nghiệm
        Nếu b!=0 và a!=0 => Phương trình có 1 nghiệm duy nhất x=-b/a;


        Nhập 2 số a và b, tìm nghiệm của phương trình bậc nhất ax+b=0.
        */
        //Khởi tạo đối tượng thuộc kiểu Scanner
        Scanner parameters = new Scanner(System.in);
        //Nhập a có kiểu float từ bàn phím thuộc đối tượng thamSo có kiểu float
        System.out.println("Nhập a");
        float a = parameters.nextFloat();
        //Nhập b có kiểu float từ bàn phím thuộc đối tượng thamSo có kiểu float
        System.out.println("Nhập b");
        float b = parameters.nextFloat();
        if (b == 0 && a == 0) {
            System.out.println("Phương trình có vô số nghiệm");
        } else if (b != 0 && a == 0) {
            System.out.println("Phương trình vô nghiệm");
        } else {
            System.out.println("Phương trình có 1 nghiệm duy nhất là: " + (-b / a));
        }
    }
}
