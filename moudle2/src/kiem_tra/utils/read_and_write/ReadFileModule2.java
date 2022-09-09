package kiem_tra.utils.read_and_write;

import kiem_tra.models.HocVien;
import kiem_tra.models.NhanVien;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadFileModule2 {
    private static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<String> strings = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            strings.add(line);
        }
        bufferedReader.close();

        return strings;
    }

    public static List<NhanVien> readFileNhanVien(String path) throws IOException {
        List<String> strings = readFile(path);
        List<NhanVien> nhanViens = new ArrayList<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                nhanViens.add(new NhanVien(info[0], info[1], info[2], info[3], info[4], Double.parseDouble(info[5]), info[6], info[7]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Truy cập vượt quá vị trí phần tử của danh sách");
        }

        return nhanViens;
    }

    public static List<HocVien> readFileHocVien(String path) throws IOException {
        List<String> strings = readFile(path);
        List<HocVien> hocViens = new ArrayList<>();
        try {
            String[] info;
            for (String line : strings) {
                info = line.split(",");
                hocViens.add(new HocVien(info[0], info[1], info[2], info[3], info[4], Double.parseDouble(info[5]), info[6], info[7]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Truy cập vượt quá vị trí phần tử của danh sách");
        }

        return hocViens;
    }
}
