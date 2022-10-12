package kiem_tra.utils.validate.nhap_thong_tin_nhan_vien;

import case_study.task_1.utils.exception.ChoiceException;

import java.util.Scanner;

public class NhapPhongBanNhanVien {
    private static Scanner scanner = new Scanner(System.in);

    public static String nhapPhongBanNhanVien() {
        int choice;
        String level;
        while (true) {
            try {
                System.out.println("--------------------------------------------------------------");
                System.out.println("Mời bạn lựa chọn phòng bạn cho nhân viên:");
                System.out.println("1. Văn phòng");
                System.out.println("2. Đào Tạo");
                System.out.println("3. Cố Vấn");
                System.out.println("4. Nhân Sự");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new ChoiceException("Lựa chọn của bạn không hợp lê!. Hãy kiểm tra lại");
                } else {
                    switch (choice) {
                        case 1:
                            level = "Văn phòng";
                            return level;
                        case 2:
                            level = "Đào Tạo";
                            return level;
                        case 3:
                            level = "Cố Vấn";
                            return level;
                        case 4:
                            level = "Nhân Sự";
                            return level;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào lựa chọn chính xác (1->4)");
            }
        }
    }
}
