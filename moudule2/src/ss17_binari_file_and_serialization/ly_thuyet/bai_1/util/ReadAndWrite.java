package ss17_binari_file_and_serialization.ly_thuyet.bai_1.util;

import ss17_binari_file_and_serialization.ly_thuyet.bai_1.model.Student;

import java.io.*;
import java.util.List;

public class ReadAndWrite {
    public static List<Student> readFile(String path) throws IOException, ClassNotFoundException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Student> list = (List<Student>) objectInputStream.readObject();
        for (Student student : list) {
            System.out.println(student);
        }
//        while (fileInputStream.available() > 0) {
//            Student student = (Student) objectInputStream.readObject();
//            System.out.println(student);
//        }
        objectInputStream.close();
        return list;
    }

    public static void writeFile(String path, List<Student> list) throws IOException {
        Student student = new Student(1, "Tiến", "20/10/1996", "Nam", 6.5, "C06");
        Student student1 = new Student(2, "Tuấn", "20/10/1996", "Nam", 1, "C06");
        Student student2 = new Student(3, "Hùng", "20/10/1996", "Nam", 2.5, "C06");
        Student student3 = new Student(4, "Nam", "20/10/1996", "Nam", 8.1, "C06");
        Student student4 = new Student(5, "Dũng", "20/10/1996", "Nam", 9.2, "C06");
      //  List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
//        objectOutputStream.writeObject(student);
//        objectOutputStream.writeObject(student1);
//        objectOutputStream.writeObject(student2);
//        objectOutputStream.writeObject(student3);
//        objectOutputStream.writeObject(student4);
        objectOutputStream.close();

    }
}
