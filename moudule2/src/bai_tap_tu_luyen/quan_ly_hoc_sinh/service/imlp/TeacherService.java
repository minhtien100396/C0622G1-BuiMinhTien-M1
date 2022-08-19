package bai_tap_tu_luyen.quan_ly_hoc_sinh.service.imlp;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Teacher;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.ITeacherService;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.utils.exception.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private Scanner scanner = new Scanner(System.in);
    public static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(1, "Nguyễn Văn Hải", "10/5/2001", "Male", "Java"));
        teachers.add(new Teacher(2, "Huỳnh Trần Chánh", "20/03/1996", "Male", "JavaScript"));
        teachers.add(new Teacher(3, "Dỗ Ức Uy", "10/03/1995", "Male", "PHP"));
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
            System.out.println("Không tồn tại giáo viên để thay đổi. Hãy thêm giáo viên vào");
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
                        for (int i = 0; i < teachers.size(); i++) {
                            if (teachers.get(i).getId() == id) {
                                count++;
                                System.out.println("Bạn chắc chắn muốn thay đổi thông tin của giáo viên không?");
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
                    break;
                } catch (IdException e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Bạn nhập sai cú pháp, hãy nhập lại");
                }

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

    @Override
    public void sortNameTeacher() {
        boolean isSwap = true;
        for (int i = 0; i < teachers.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teachers.size() - 1 - i; j++) {
                if (teachers.get(j).getName().toLowerCase().compareTo(teachers.get(j + 1).getName().toLowerCase()) >= 0) {
                    isSwap = true;
                    Teacher temp = teachers.get(j + 1);
                    teachers.set(j + 1, teachers.get(j));
                    teachers.set(j, temp);
                }
            }
        }
        displayTeacher();
    }

    public Teacher findTeacher() {
        int id;
        while (true) {
            try {
                System.out.println("Nhâp vào ID bạn muốn thao tác");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IdException("ID phải là số nguyên dương");
                } else {
                    for (int i = 0; i < teachers.size(); i++) {
                        if (teachers.get(i).getId() == id) {
                            return teachers.get(i);
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


    public Teacher infoTeacher() {
        int id;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào Id của giáo viên");
                id = Integer.parseInt(scanner.nextLine());
                if (id <= 0) {
                    throw new IdException("ID phải là số nguyên dương. Vui lòng nhập lại");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID phải là số. Vui lòng nhập lại");
            } catch (IdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }
        }
        String name;
        String str = "123456\7890!@#$%^&*()_+-={}[]';:'?<>,./|~`";
        String[] newStr = str.split("");
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào tên của giáo viên");
                name = scanner.nextLine();
                String[] newName = name.trim().split("");
                for (int i = 0; i < newName.length; i++) {
                    for (int j = 0; j < newStr.length; j++) {
                        if ((newName[i].equalsIgnoreCase(newStr[j]))) {
                            throw new NameException("Tên không hợp lệ. Hãy nhập lại!");
                        }
                    }
                }
                break;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }
        }

        String dateOfBirth;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào ngày tháng năm sinh của giáo viên (DD/MM/YYYY)");
                dateOfBirth = scanner.nextLine();
                String[] arr = dateOfBirth.trim().split("/");
                for (int i = 0; i < arr.length; i++) {
                    Integer.parseInt(arr[i]);
                    if (Integer.parseInt(arr[0]) <= 0 || Integer.parseInt(arr[0]) > 31) {
                        throw new DayBirthDayException("Ngày sinh không hợp lệ (1->31)");
                    }
                    if (Integer.parseInt(arr[1]) <= 0 || Integer.parseInt(arr[1]) > 12) {
                        throw new MonthBirthDayException("Tháng sinh không hợp lệ (1->12)");
                    }
                    if (Integer.parseInt(arr[2]) <= 1920 || Integer.parseInt(arr[1]) > 2022) {
                        throw new YearBirthDayException("Năm sinh không hợp lệ (1920->2022)");
                    }

                }

                break;
            } catch (DayBirthDayException e) {
                System.out.println(e.getMessage());
            } catch (MonthBirthDayException e) {
                System.out.println(e.getMessage());
            } catch (YearBirthDayException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập đúng cú pháp");
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }

        }
        String gender;
        boolean check;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào giới tính cho giáo viên");
                gender = scanner.nextLine();
                check = (!(gender.equalsIgnoreCase("nam"))) && (!(gender.equalsIgnoreCase(" nữ")));
                if (check) {
                    throw new GenderException("Hãy nhập lại giới tính!!! (Giới tính chỉ có thể là \"nam\" hoặc \"nữ\")");
                }
                break;
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }
        }

        String specialize;
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào chuyên ngành của giáo viên");
                specialize = scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Chương trình có vấn đề. Hãy kiểm tra lại");
            }
        }

        Teacher teacher = new Teacher(id, name, dateOfBirth, gender, specialize);
        return teacher;
    }
}
