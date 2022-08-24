package ss17_binari_file_and_serialization.bai_tap.bai_2;

import ss17_binari_file_and_serialization.bai_tap.bai_2.utils.ReadFile;
import ss17_binari_file_and_serialization.bai_tap.bai_2.utils.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainCoppyByteStream {
    private static final String PATH_FILE = "src\\ss17_binari_file_and_serialization\\bai_tap\\bai_2\\data\\source_file.dat";
    private static final String PATH_FILE1 = "src\\ss17_binari_file_and_serialization\\bai_tap\\bai_2\\data\\target_file.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Object> studentList = new ArrayList<>();
//        studentList.add(new Student(1, "Bia"));
//        studentList.add(new Student(2, "Tiến"));
//        studentList.add(new Student(3, "Vinh"));
//        System.out.println("-------------------------------------------");
//        System.out.println("Dữ liệu ở file ban đầu");
        //WriteFile.writeFile(PATH_FILE, studentList);
        List<Object> list = ReadFile.readFile(PATH_FILE);
//        System.out.println("-------------------------------------------");
//        System.out.println("Dữ liệu ở file sau khi coppy");
        WriteFile.writeFile(PATH_FILE1,list);
    }
}
