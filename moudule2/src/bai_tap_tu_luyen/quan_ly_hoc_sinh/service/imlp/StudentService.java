package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private Scanner scanner = new Scanner(System.in);
    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "Nguyễn Văn Huy", "10/25/2001", "Male", 2, "C0622G1"));
        students.add(new Student(2, "Bùi Minh Tiến", "10/03/1996", "Male", 3, "C0622G1"));
        students.add(new Student(2, "Dỗ Đức Uy", "20/03/1995", "Male", 4, "C0622G1"));
    }

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
        if (students.isEmpty()) {
            System.out.println("Không tồn tại học sinh để thay đổi. Hãy thêm học sinh vào");
        } else {
            System.out.println("Hãy nhập ID bạn muốn thay đổi");
            int id = Integer.parseInt(scanner.nextLine());
            int count = 0;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId() == id) {
                    count++;
                    System.out.println("Bạn chắc chắn muốn thay đổi thông tin của học sinh không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        students.set(i, infoStudent());
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
    public void findIdStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("ID bạn nhập không hợp lệ. Hãy nhập lại");
        } else {
            System.out.println("Thông tin tìm được là:");
            System.out.println(student);
        }
    }

    @Override
    public void findNameStuden() {
        System.out.println("Hãy nhập vào tên bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        int count = 1;
        for (Student student : students) {
            if (student.getName().contains(name)) {
                count++;
                System.out.println("Thông tin sau khi tìm kiếm được là:");
                System.out.println(student);
            }
        }
        if (count == 0) {
            System.out.println("Tên bạn nhập không tồn tại");
        }
    }

    @Override
    public void sortNameStudent() {
        boolean isSwap = true;
        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getName().toLowerCase().compareTo(students.get(j + 1).getName().toLowerCase()) >= 0) {
                    isSwap = true;
                    Student temp = students.get(j + 1);
                    students.set(j + 1, students.get(j));
                    students.set(j, temp);
                }
            }


        }
        displayStudent();
    }

    public Student findStudent() {
        System.out.println("Nhâp vào ID bạn muốn thao tác");
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
