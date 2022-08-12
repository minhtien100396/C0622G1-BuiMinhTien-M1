//package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;
//
//import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IMainControllerService;
//import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IStudentService;
//import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;
//
//import java.util.Scanner;
//
//public class MainControllerService implements IMainControllerService {
//    @Override
//    public void teacherManagement() {
//        Scanner scanner = new Scanner(System.in);
//        ITeacherService teacherService = new TeacherService();
//        while (true) {
//            System.out.println("---------------------------------------");
//            System.out.println("Chào mừng bạn đến với CodeGym");
//            System.out.println("1. Hiển thị danh sách giáo viên ở CodeGym");
//            System.out.println("2. Thêm giáo viên");
//            System.out.println("3. Xóa giáo viên");
//            System.out.println("4. Thay đổi thông tin giáo viên");
//            System.out.println("5. Exit");
//            System.out.println("Hãy nhập lựa chọn của bạn (1->5)");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    teacherService.displayTeacher();
//                    break;
//                case 2:
//                    teacherService.addTeacher();
//                    break;
//                case 3:
//                    teacherService.removeTeacher();
//                    break;
//                case 4:
//                    teacherService.changeTeacherInfo();
//                    break;
//                case 5:
//                    System.out.println("Cám ơn bạn đã sử dụng phần mềm của chúng tôi.");
//                    return;
//            }
//        }
//    }
//
//    @Override
//    public void studentManagement() {
//        Scanner scanner = new Scanner(System.in);
//        IStudentService studentService = new StudentService();
//        while (true) {
//            System.out.println("---------------------------------------");
//            System.out.println("Chào mừng bạn đến với lớp C0622G1");
//            System.out.println("1. Hiển thị danh sách lớp");
//            System.out.println("2. Thêm học sinh");
//            System.out.println("3. Xóa học sinh");
//            System.out.println("4. Thay đổi thông tin học sinh");
//            System.out.println("5. Exit");
//            System.out.println("Hãy nhập lựa chọn của bạn (1->5)");
//            int choice = Integer.parseInt(scanner.nextLine());
//            switch (choice) {
//                case 1:
//                    studentService.displayStudent();
//                    break;
//                case 2:
//                    studentService.addStudent();
//                    break;
//                case 3:
//                    studentService.removeStudent();
//                    break;
//                case 4:
//                    studentService.changeStudenInfo();
//                    break;
//                case 5:
//                    System.out.println("Cám ơn bạn đã sử dụng phần mềm của chúng tôi.");
//                    return;
//            }
//        }
//    }
//}
