package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.IStudentService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.read_and_write.ReadFileUtil;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.read_and_write.WriteFileUtil;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.*;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.validate.Validate;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class StudentService implements IStudentService {
    private Scanner scanner = new Scanner(System.in);
    public static List<Student> students;
    private static final String PATH_FILE = "src\\bai_tap_tu_luyen\\quan_ly_hoc_sinh\\data\\students.txt";

    @Override
    public void addStudent() throws IOException, ClassNotFoundException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Bạn đã thêm thành công!");
        WriteFileUtil.writeStudentFile(PATH_FILE, students);
    }

    @Override
    public void displayStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void removeStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
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
        WriteFileUtil.writeStudentFile(PATH_FILE, students);
    }

    @Override
    public void changeStudenInfo() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);

        if (students.isEmpty()) {
            System.out.println("Không tồn tại học sinh để thay đổi. Hãy thêm học sinh vào");
        } else {
            int id;
            int count = 0;
            while (true) {
                try {
                    System.out.println("Hãy nhập ID bạn muốn thay đổi");
                    id = Integer.parseInt(scanner.nextLine());
                    if (id <= 0) {
                        throw new IdException("ID phải là số nguyên dương");
                    } else {
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
                    break;
                } catch (IdException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập sai cú pháp, hãy nhập lại");
                } catch (Exception e) {
                    System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
                }

            }
        }
        WriteFileUtil.writeStudentFile(PATH_FILE, students);

    }

    @Override
    public void findIdStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);

        Student student = this.findStudent();
        if (student == null) {
            System.out.println("ID bạn nhập không hợp lệ. Hãy nhập lại");
        } else {
            System.out.println("Thông tin tìm được là:");
            System.out.println(student);
        }
    }

    @Override
    public void findNameStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
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
    public void sortNameStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
//        boolean isSwap = true;
//        for (int i = 0; i < students.size() - 1 && isSwap; i++) {
//            isSwap = false;
//            for (int j = 0; j < students.size() - 1 - i; j++) {
//                if (students.get(j).getName().toLowerCase().compareTo(students.get(j + 1).getName().toLowerCase()) >= 0) {
//                    isSwap = true;
//                    Student temp = students.get(j + 1);
//                    students.set(j + 1, students.get(j));
//                    students.set(j, temp);
//                }
//            }
//        }
        Collections.sort(students, Comparator.comparingDouble(Student::getPoint));
        WriteFileUtil.writeStudentFile(PATH_FILE, students);
        displayStudent();
    }


    public Student findStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
        int id;
        while (true) {
            try {
                System.out.println("Nhâp vào ID bạn muốn thao tác");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IdException("ID phải là số nguyên dương");
                } else {
                    for (int i = 0; i < students.size(); i++) {
                        if (students.get(i).getId() == id) {
                            return students.get(i);
                        }
                    }
                    return null;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID là một số. Vui lòng nhập lại!");
            } catch (IdException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public Student infoStudent() throws IOException {
        students = ReadFileUtil.readStudentFile(PATH_FILE);
        int id = getIdAndCheck();
        String name = Validate.inputName("Tên học sinh");
        String dateOfBirth = Validate.inputDateOfBirth("ngày tháng năm sinh");
        String gender = Validate.inputGender("giới tính");
        double point = Validate.inputPoint("điểm của học sinh");
        String nameClass = Validate.inputClassName("tên lớp");
        Student student = new Student(id, name, dateOfBirth, gender, point, nameClass);
        return student;
    }

    private int getIdAndCheck() {
        int id;
        while (true) {
            id = Validate.inputId("ID");
            if (checkID(id)) {
                break;
            } else {
                System.out.println("ID " + id + " đã tồn tại");
            }
        }
        return id;
    }

    private boolean checkID(int id) {
        for (Student student : students) {
            if (student.getId() == id)
                return false;
        }
        return true;
    }
}
