package ss17_binari_file_and_serialization.thuc_hanh.bai_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String PATH_FILE = "src\\ss17_binari_file_and_serialization\\thuc_hanh\\bai_1\\data\\students.dat";

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Tiến", "Huế"));
        studentList.add(new Student(2, "Giang", "Quảng Bình"));
        studentList.add(new Student(3, "Huy", "Quảng Trị"));
        studentList.add(new Student(4, "Sơn", "Đà Nẵng"));
        writeToObject(PATH_FILE, studentList);
        readDataFromFile(PATH_FILE);


    }

    public static void writeToObject(String path, List<Student> students) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            if (fileInputStream.available()>0){

            }
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }
}
