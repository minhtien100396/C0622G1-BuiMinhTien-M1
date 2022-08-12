package bai_tap_tu_luyen.quan_ly_hoc_sinh.controller;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp.TeacherService;

import java.util.Scanner;

public class TeacherController {
    public static void teacherManagement() {
        Scanner scanner = new Scanner(System.in);
        ITeacherService teacherService = new TeacherService();
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("Chào mừng bạn đến với CodeGym");
            System.out.println("1. Hiển thị danh sách giáo viên ở CodeGym");
            System.out.println("2. Thêm giáo viên");
            System.out.println("3. Xóa giáo viên");
            System.out.println("4. Thay đổi thông tin giáo viên");
            System.out.println("5. Exit");
            System.out.println("Hãy nhập lựa chọn của bạn (1->5)");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherService.displayTeacher();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.removeTeacher();
                    break;
                case 4:
                    teacherService.changeTeacherInfo();
                    break;
                case 5:
                    return;
            }
        }
    }
}
