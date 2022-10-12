package kiem_tra.utils.validate.nhap_thong_tin_cho_hoc_vien;

import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import kiem_tra.models.HocVien;
import kiem_tra.utils.read_and_write.ReadFileModule2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NhapMaHocVien {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX =  "^(HV\\-)[0-9]{3}$";


    public static String nhapMaHocVien() throws IOException {
        String id;
        List<HocVien> hocViens = ReadFileModule2.readFileHocVien("src\\kiem_tra\\data\\hoc_vien.csv");

        while (true) {
            try {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã số Học Viên (HV-XXX)");
                id = scanner.nextLine();
                for (HocVien hocVien : hocViens) {
                    if (hocVien.getMaDinhDanh().equals(id)) {
                        throw new DuplicatePersomnalRecordException("Mã học viên bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("Mã học viên không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
