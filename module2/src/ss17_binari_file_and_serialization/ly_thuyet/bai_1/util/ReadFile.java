package ss17_binari_file_and_serialization.ly_thuyet.bai_1.util;

import ss17_binari_file_and_serialization.ly_thuyet.bai_1.model.Student;

import java.io.*;
import java.util.List;

public class ReadFile {
    public static final String PATH_FILE = "src\\ss17_binari_file_and_serialization\\ly_thuyet\\bai_1\\data\\student.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File(PATH_FILE);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Student> list = (List<Student>)objectInputStream.readObject();
        for (Student student:list) {
            System.out.println(student);
        }
//        while (fileInputStream.available() > 0) {
//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student);
//        }
        objectInputStream.close();

    }
}
