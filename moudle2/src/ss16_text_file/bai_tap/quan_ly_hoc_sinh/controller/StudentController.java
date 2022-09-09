package ss16_text_file.bai_tap.quan_ly_hoc_sinh.controller;

import ss16_text_file.bai_tap.quan_ly_hoc_sinh.service.IStudentService;
import ss16_text_file.bai_tap.quan_ly_hoc_sinh.service.imlp.StudentService;
import ss16_text_file.bai_tap.quan_ly_hoc_sinh.service.utils.exception.SearchException;

import java.io.IOException;
import java.util.Scanner;

public class StudentController {
    public static void studentManagement() throws IOException, ClassNotFoundException {
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
            System.out.println("6. Sắp xếp học sinh theo tên");
            System.out.println("7. Exit");
            System.out.println("Hãy nhập lựa chọn của bạn (1->7)");
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
                    int choice2;
                    while (true) {
                        try {
                            System.out.println("Chào mừng bạn đến với chức năng tìm kiếm");
                            System.out.println("1. Tìm kiếm theo ID");
                            System.out.println("2. Tìm kiếm theo tên");
                            System.out.println("3. Exit");
                            System.out.println("Mời bạn nhập vào kiểu tìm kiếm:");
                            choice2 = Integer.parseInt(scanner.nextLine());
                            if (choice2 < 1 || choice2 > 3) {
                                throw new SearchException("Vui lòng chọn đúng kiểu tìm kiếm!");
                            } else {
                                switch (choice2) {
                                    case 1:
                                        studentService.findIdStudent();
                                        break;
                                    case 2:
                                        studentService.findNameStudent();
                                        break;
                                    case 3:
                                        return;
                                }
                            }
                        } catch (SearchException e) {
                            System.out.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println("Nhập sai định dạng. Vui lòng nhập lại");
                        } catch (Exception e) {
                            System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
                        }
                    }
                case 6:
                    studentService.sortNameStudent();
                    break;
                case 7:
                    return;
            }
        }
    }
}
