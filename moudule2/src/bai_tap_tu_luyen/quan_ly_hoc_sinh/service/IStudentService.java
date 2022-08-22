package bai_tap_tu_luyen.quan_ly_hoc_sinh.service;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void displayStudent() throws IOException;

    void removeStudent() throws IOException;

    void changeStudenInfo() throws IOException;

    void findIdStudent() throws IOException;

    void findNameStudent() throws IOException;

    void sortNameStudent() throws IOException;

}
