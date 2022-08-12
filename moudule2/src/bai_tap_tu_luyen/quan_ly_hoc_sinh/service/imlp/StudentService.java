package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private Scanner scanner = new Scanner(System.in);
    public List<Student> students = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Bạn đã thêm thành công!");
    }

    @Override
    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Học sinh này không có trong lớp");
        } else {
            System.out.println("Bạn chắc chắn muốn xóa học sinh có id là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Bạn đã xóa thành công");
            }
        }
    }

    @Override
    public void changeStudenInfo() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Học sinh bạn cần thay đổi thông tin không có trong lớp ");
        } else {
            System.out.println("Bạn chắc chắn muốn thay đổi thông tin của học sinh có ID là " + student.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                students.set((student.getId() - 1), this.infoStudent());
                System.out.println("Bạn đã thay đổi thông tin thành công");
            }
        }
    }

    public Student findStudent() {
        System.out.println("Nhâp vào ID");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }


    public Student infoStudent() {
        System.out.println("Mời bạn nhập vào Id của học sinh");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào tên của học sinh");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập vào ngày tháng năm sinh của học sinh");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Mời bạn nhập vào giới tính cho học sinh");
        String gender;
        boolean check;
        do {
            gender = scanner.nextLine();
            check = (!(gender.equalsIgnoreCase("male"))) && (!(gender.equalsIgnoreCase("female")));
            if (check) {
                System.out.println("Giới tính không phù hợp hãy nhập lại");
            }
        } while (check);
        System.out.println("Mời bạn nhập vào số điểm của học sinh");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập vào lớp học của học sinh");
        String nameClass = scanner.nextLine();
        Student student = new Student(id, name, dateOfBirth, gender, point, nameClass);
        return student;
    }
}
