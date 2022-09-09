package kiem_tra.utils.read_and_write;

import case_study.task_1.models.Employee;
import kiem_tra.models.HocVien;
import kiem_tra.models.NhanVien;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileModule2 {
    private static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(data);
        bufferedWriter.close();
    }

    public static void writeFileNhanVien(String path, List<NhanVien> nhanViens) throws IOException {
        String data = "";
        for (NhanVien nhanVien : nhanViens) {
            data += nhanVien.toString();
            data += "\n";
        }

        writeFile(path, data);
    }
    public static void writeFileHocVien(String path, List<HocVien> hocViens) throws IOException {
        String data = "";
        for (HocVien hocVien : hocViens) {
            data += hocVien.toString();
            data += "\n";
        }

        writeFile(path, data);
    }

}
