package ss15_xu_ly_ngoai_le.bai_tap;

import java.util.Scanner;

public class InputTheSideOfTheTriangle {
    /**
     * Cách 1: Throw-Throws
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 3 cạnh của tam giác:");
        double a;
        double b;
        double c;
        while (true) {
            try {
                System.out.println("Cạnh a");
                a = Double.parseDouble(scanner.nextLine());
                System.out.println("Cạnh b");
                b = Double.parseDouble(scanner.nextLine());
                System.out.println("Cạnh c");
                c = Double.parseDouble(scanner.nextLine());
                checkInput(a, b, c);
                System.out.println("Cạnh a =" + a);
                System.out.println("Cạnh b =" + b);
                System.out.println("Cạnh c =" + c);
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Cạnh của tam giác phải là một số!");
            } catch (SumIllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println("Chương trình xảy ra lỗi. Hãy kiểm tra lại");
            }
        }

    }

    public static void checkInput(double a, double b, double c) throws IllegalTriangleException, SumIllegalTriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException(" Cạnh của tam giác không được là số âm");
        }
        if ((a + b) < c || (a + c) < b || (b + c) < a) {
            throw new SumIllegalTriangleException("Tổng 2 cạnh của tam giác phải lớn hơn cạnh còn lại. Nhập lại đi thím!");
        }
    }


    /**
     * Cách 2: Try-Catch trực tiếp
     * @param
     */
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Mời bạn nhập vào 3 cạnh của tam giác:");
//        double a;
//        double b;
//        double c;
//        while (true) {
//            try {
//                System.out.println("Cạnh a");
//                a = Double.parseDouble(scanner.nextLine());
//                System.out.println("Cạnh b");
//                b = Double.parseDouble(scanner.nextLine());
//                System.out.println("Cạnh c");
//                c = Double.parseDouble(scanner.nextLine());
//                checkInput(a, b, c);
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Cạnh của tam giác phải là một số!");
//            }
//        }
//    }
//
//    public static void checkInput(double a, double b, double c) {
//        if (a < 0 || b < 0 || c < 0) {
//            try {
//                throw new IllegalTriangleException(" Cạnh của tam giác không được là số âm");
//            } catch (IllegalTriangleException e) {
//                System.out.println(e.getMessage());
//            }
//        }else if ((a + b) < c || (a + c) < b || (b + c) < a) {
//            try {
//                throw new SumIllegalTriangleException("Tổng 2 cạnh của tam giác phải lớn hơn cạnh còn lại. Nhập lại đi thím!");
//            } catch (SumIllegalTriangleException e) {
//                System.out.println(e.getMessage());
//            }
//        }else {
//            System.out.println("Cạnh a =" + a);
//            System.out.println("Cạnh b =" + b);
//            System.out.println("Cạnh c =" + c);
//        }
//    }
}
