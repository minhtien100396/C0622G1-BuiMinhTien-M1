package ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_1.controller;

import ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_1.service.IStudentService;
import ss9_array_list_linked_list.thuc_hanh.mo_hình_mvc.bai_1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static Scanner scanner = new Scanner(System.in);
    private IStudentService studentService =new StudentService();
    public void menuManagement(){
        while (true){
            System.out.println("----------------------------------------");
            System.out.println("Chào mừng bạn đến với lớp C0622G1");
            System.out.println("1. Hiển thị danh sách học viên");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Cập nhật thông tin học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Exit");
            System.out.println("Mời bạn nhập chức năng 1->5: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    studentService.displayAllStudent();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    break;
                case 4:
                    studentService.removeStudent();
                    break;
                case 5:
                    return;
            }
        }
    }
}
