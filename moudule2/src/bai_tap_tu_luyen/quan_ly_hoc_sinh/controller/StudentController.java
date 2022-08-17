package bai_tap_tu_luyen.quan_ly_hoc_sinh.controller;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IStudentService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp.StudentService;

import java.util.Scanner;

public class StudentController {
    public static void studentManagement() {
        Scanner scanner = new Scanner(System.in);
        IStudentService studentService = new StudentService();
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("Chào mừng bạn đến với lớp C0622G1");
            System.out.println("1. Hiển thị danh sách lớp");
            System.out.println("2. Thêm học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Thay đổi thông tin học sinh");
            System.out.println("5. Tìm kiếm học sinh");
            System.out.println("5. Exit");
            System.out.println("Hãy nhập lựa chọn của bạn (1->5)");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentService.displayStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.removeStudent();
                    break;
                case 4:
                    studentService.changeStudenInfo();
                    break;
                case 5:
                    System.out.println("Chào mừng bạn đến với chức năng tìm kiếm");
                    System.out.println("1. Tìm kiếm theo ID");
                    System.out.println("2. Tìm kiếm theo tên");
                    System.out.println("3. Exit");
                    System.out.println("Mời bạn nhập vào kiểu tìm kiếm:");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2){
                        case 1:
                            studentService.findIdStudent();
                            break;
                        case 2:
                            studentService.findNameStuden();
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 6:
                    return;
            }
        }
    }
}
