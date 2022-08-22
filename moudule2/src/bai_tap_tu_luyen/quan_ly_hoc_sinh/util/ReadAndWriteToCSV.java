package bai_tap_tu_luyen.quan_ly_hoc_sinh.util;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReadAndWriteToCSV {
    public static void writeListStudentToCSV(List<Student> students, String pathFile, boolean append) {
        File file = new File(pathFile);
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student:students) {
                bufferedWriter.write(student.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
