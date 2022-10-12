package bai_tap_tu_luyen.quan_ly_hoc_sinh.service;

import java.io.IOException;

public interface ITeacherService {

    void addTeacher() throws IOException;

    void displayTeacher() throws IOException;

    void removeTeacher() throws IOException;

    void changeTeacherInfo() throws IOException;

    void findIdTeacher() throws IOException;

    void findNameTeacher() throws IOException;

    void sortNameTeacher() throws IOException;
}
