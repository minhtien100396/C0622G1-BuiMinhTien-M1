package kiem_tra.utils.validate.nhap_thong_tin_nhan_vien;

import case_study.task_1.utils.exception.DuplicatePersomnalRecordException;
import kiem_tra.models.NhanVien;
import kiem_tra.utils.read_and_write.ReadFileModule2;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NhapMaNhanVien {
    private static Scanner scanner = new Scanner(System.in);
    private static String ID_REGEX = "^(NV\\-)[0-9]{3}$";


    public static String nhapMaNhanVien() throws IOException {
        String id;
        List<NhanVien> nhanViens = ReadFileModule2.readFileNhanVien("src\\kiem_tra\\data\\nhan_vien.csv");

        while (true) {
            try {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã số Nhân viên (NV-XXX)");
                id = scanner.nextLine();
                for (NhanVien nhanVien : nhanViens) {
                    if (nhanVien.getMaDinhDanh().equals(id)) {
                        throw new DuplicatePersomnalRecordException("Mã số Nhân viên bạn nhập đã tồn tại!. Vui lòng nhập lại");
                    }
                }
                if (id.matches(ID_REGEX)) {
                    break;
                } else {
                    throw new DuplicatePersomnalRecordException("Mã số Nhân viên không hợp lệ. Hãy kiểm tra lại!");
                }
            } catch (DuplicatePersomnalRecordException e) {
                System.out.println(e.getMessage());
            }
        }
        return id;
    }
}
