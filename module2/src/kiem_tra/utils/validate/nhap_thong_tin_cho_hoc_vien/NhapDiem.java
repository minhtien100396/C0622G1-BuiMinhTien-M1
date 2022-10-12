package kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien;

import case_study.task_1.utils.exception.SalaryException;

import java.util.Scanner;

public class NhapDiem {
    private static Scanner scanner = new Scanner(System.in);

    public static double nhapDiem() {
        double salary;
        while (true) {
            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào điểm của học viên:");
                salary = Double.parseDouble(scanner.nextLine());
                if (salary < 0 || salary >10) {
                    throw new SalaryException("Điểm của học viên không hợp lệ!. Hãy kiểm tra lại (điểm>0&& điểm <=10)");
                }
                break;
            } catch (SalaryException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Điểm phải là một chữ số!. Vui lòng nhập lại");
            }
        }
        return salary;
    }
}
