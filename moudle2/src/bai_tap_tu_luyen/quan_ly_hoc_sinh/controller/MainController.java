package bai_tap_tu_luyen.quan_ly_hoc_sinh.controller;


import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.SearchException;

import java.util.Scanner;

public class MainController {
    public static void manage() {
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        int choice;
        while (true) {
            try {
                System.out.println("Hãy lựa chọn đối tượng muốn quản lý");
                System.out.println("1. Giáo viên");
                System.out.println("2. Học sinh");
                System.out.println("3. Exit");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 3) {
                    throw new SearchException("Vui lòng nhập đúng vị trí muốn chọn!");
                } else {
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
            } catch (SearchException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập đúng cú pháp!");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }
        }
    }
}
