package ss15_xu_ly_ngoai_le.thuc_hanh;

import java.util.Scanner;

public class NumberFormatException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào x");
        double x = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào y");
        double y = Integer.parseInt(scanner.nextLine());
    }

//    public static int setUpcalc(double x, double y){
//        try {
//
//        }
//        double phepCong = x+y;
//        double phepTru = x-y;
//        double phepNhan = x*y;
//        double phepChia = x/y;
//
//
//        return result;
//    }

}
