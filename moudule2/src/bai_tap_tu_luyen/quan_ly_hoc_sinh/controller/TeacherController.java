package bai_tap_tu_luyen.quan_ly_hoc_sinh.controller;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp.TeacherService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.SearchException;

import java.io.IOException;
import java.util.Scanner;

public class TeacherController {
    public static void teacherManagement() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ITeacherService teacherService = new TeacherService();
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("Chào mừng bạn đến với CodeGym");
            System.out.println("1. Hiển thị danh sách giáo viên ở CodeGym");
            System.out.println("2. Thêm giáo viên");
            System.out.println("3. Xóa giáo viên");
            System.out.println("4. Thay đổi thông tin giáo viên");
            System.out.println("5. Tìm kiếm thông tin giáo viên");
            System.out.println("6. Sắp xếp theo tên giáo viên");
            System.out.println("7. Exit");
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
                                        teacherService.findIdTeacher();
                                        break;
                                    case 2:
                                        teacherService.findNameTeacher();
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
                    teacherService.sortNameTeacher();
                    break;
                case 7:
                    return;
            }
        }
    }
}
