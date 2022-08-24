package ss17_binari_file_and_serialization.ly_thuyet.bai_1.util;

import ss17_binari_file_and_serialization.ly_thuyet.bai_1.model.Student;

import java.io.IOException;
import java.util.List;

public class Main {
    public static final String PATH_FILE = "src\\ss17_binari_file_and_serialization\\ly_thuyet\\bai_1\\data\\student.dat";
    public static final String PATH_FILE1 = "src\\ss17_binari_file_and_serialization\\ly_thuyet\\bai_1\\data\\newstudent.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> list = ReadAndWrite.readFile(PATH_FILE);
        ReadAndWrite.writeFile(PATH_FILE1,list);
    }
}
