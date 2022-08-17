package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Teacher;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private Scanner scanner = new Scanner(System.in);
    public static List<Teacher> teachers = new ArrayList<>();
    static {
        teachers.add(new Teacher(1, "Nguyễn Văn Hải", "10/5/2001", "Male", "Java"));
        teachers.add(new Teacher(2, "Nguyễn Trần Chánh", "20/03/1996", "Male", "JavaScript"));
        teachers.add(new Teacher(3, "Đỗ Ức Uy", "10/03/1995", "Male", "PHP"));
    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Bạn đã thêm thành công!");
    }

    @Override
    public void displayTeacher() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void removeTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Giáo viên này không có trong CodeGym");
        } else {
            System.out.println("Bạn chắc chắn muốn xóa giáo viên có id là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Bạn đã xóa thành công");
            }
        }
    }

    @Override
    public void changeTeacherInfo() {
        if (teachers.isEmpty()) {
            System.out.println("Không tồn tại học sinh để thay đổi. Hãy thêm học sinh vào");
        } else {
            System.out.println("Hãy nhập ID bạn muốn thay đổi");
            int id = Integer.parseInt(scanner.nextLine());
            int count = 0;
            for (int i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).getId() == id) {
                    count++;
                    System.out.println("Bạn chắc chắn muốn thay đổi thông tin của học sinh không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        teachers.set(i, infoTeacher());
                        System.out.println("Bạn đã thay đổi thông tin thành công");
                    }
                }
            }
            if (count == 0) {
                System.out.println("ID bạn nhập không hợp lệ");
            }
        }
    }

    @Override
    public void findIdTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("ID bạn nhập không hợp lệ. Hãy nhập lại");
        } else {
            System.out.println("Thông tin tìm được là:");
            System.out.println(teacher);
        }
    }

    @Override
    public void findNameTeacher() {
        System.out.println("Hãy nhập vào tên bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        int count = 1;
        for (Teacher teacher : teachers) {
            if (teacher.getName().contains(name)) {
                count++;
                System.out.println("Thông tin sau khi tìm kiếm được là:");
                System.out.println(teacher);
            }
        }
        if (count == 0) {
            System.out.println("Tên bạn nhập không tồn tại");
        }
    }

    public Teacher findTeacher() {
        System.out.println("Nhâp vào ID bạn muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }


    public Teacher infoTeacher() {
        System.out.println("Mời bạn nhập vào Id của giáo viên");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào tên của giáo viên");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập vào ngày tháng năm sinh của giáo viên");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Mời bạn nhập vào giới tính cho giáo viên");
        String gender;
        boolean check;
        do {
            gender = scanner.nextLine();
            check = (!(gender.equalsIgnoreCase("male"))) && (!(gender.equalsIgnoreCase("female")));
            if (check) {
                System.out.println("Giới tính không phù hợp hãy nhập lại");
            }
        } while (check);
        System.out.println("Mời bạn nhập vào chuyên ngành của giáo viên");
        String specialize = scanner.nextLine();
        Teacher teacher = new Teacher(id, name, dateOfBirth, gender, specialize);
        return teacher;
    }
}
