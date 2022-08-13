package bai_tap_tu_luyen.quan_ly_hoc_sinh.controller;

//import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IMainControllerService;
//import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp.MainControllerService;

import java.util.Scanner;

public class MainController {
    public static void manage() {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        while (true) {
            System.out.println("Hãy lựa chọn đối tượng muốn quản lý");
            System.out.println("1. Giáo viên");
            System.out.println("2. Học sinh");
            System.out.println("3. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherController.teacherManagement();
                    break;
                case 2:
                    studentController.studentManagement();
                    break;
                case 3:
                    System.out.println("Cám ơn bạn đã sử dụng phần mềm của chúng tôi.");
                    return;
            }
        }
    }
}
