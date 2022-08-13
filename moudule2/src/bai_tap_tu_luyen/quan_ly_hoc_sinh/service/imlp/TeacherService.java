package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Teacher;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private Scanner scanner = new Scanner(System.in);
    public List<Teacher> teachers = new ArrayList<>();

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
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Giáo viên bạn cần thay đổi thông tin không có trong trung tâm ");
        } else {
            System.out.println("Bạn chắc chắn muốn thay đổi thông tin của giáo viên có ID là " + teacher.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                    teachers.set(teacher.getId(),infoTeacher() );
                    System.out.println("Bạn đã thay đổi thông tin thành công");
            }
        }
    }
    public Teacher findTeacher() {
        System.out.println("Nhâp vào ID bạn muốn xử lý");
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
