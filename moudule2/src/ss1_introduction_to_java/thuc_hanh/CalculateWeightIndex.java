package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class CalculateWeightIndex {
    public static void main(String[] args) {
        /*
        bmi = weight / height2
        */

        //Tạo đổi tượng Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cân nặng của cơ thể");
        //Nhập dữ liệu kiểu số thực từ bàn phím
        float weight = scanner.nextFloat();
        System.out.println("Nhập chiều cao");
        float height = scanner.nextFloat();
        float bmi = weight / (float) (Math.pow(height, 2));
        if (bmi < 18.5) {
            System.out.println("BMI = " + bmi);
            System.out.println("Thiếu cân");
        } else if (bmi < 25) {
            System.out.println("BMI = " + bmi);
            System.out.println("Cân nặng bình thường");
        } else if (bmi < 30) {
            System.out.println("BMI = " + bmi);
            System.out.println("Thừa cân");
        } else {
            System.out.println("BMI = " + bmi);
            System.out.println("Béo phì");
        }
    }
}
