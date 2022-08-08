package ss4_lop_va_doi_tuong_trong_java.bai_tap_huong_doi_tuong.bai_1;

import java.util.Scanner;

public class TestCandidate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số thí sinh");
        int number;
        do {
            number = Integer.parseInt(scanner.nextLine());
            if (number <= 0) {
                System.out.println("Số lượng thí sinh phải là một số nguyên dương");
            }
        } while (number <= 0);

        //Tảo mảng đối tượng
       Candidate array[] = new Candidate[number];
        for (int i = 0; i < number; i++) {
            array[i].getDiemThiAnh();
        }
    }

}
