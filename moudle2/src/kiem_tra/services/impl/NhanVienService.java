package kiem_tra.services.impl;

import bai_tap_tu_luyen.quan_ly_hoc_sinh.model.Student;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.read_and_write.ReadFileUtil;
import bai_tap_tu_luyen.quan_ly_hoc_sinh.service.read_and_write.WriteFileUtil;
import case_study.task_1.models.Employee;
import case_study.task_1.utils.read_and_write.ReadFileUtils;
import case_study.task_1.utils.read_and_write.WriteFileUtils;
import kiem_tra.models.NhanVien;
import kiem_tra.services.INhanVienService;
import kiem_tra.utils.read_and_write.ReadFileModule2;
import kiem_tra.utils.read_and_write.WriteFileModule2;
import kiem_tra.utils.validate.NhapThongTinNhanVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NhanVienService implements INhanVienService {
    private Scanner scanner = new Scanner(System.in);
    private static List<NhanVien> nhanViens = new ArrayList<>();
    private final String NHAN_VIEN_FILE = "src\\kiem_tra\\data\\nhan_vien.csv";

    @Override
    public void themMoiNhanVien() throws IOException {
        nhanViens = ReadFileModule2.readFileNhanVien(NHAN_VIEN_FILE);
        NhanVien nhanVien = this.thongTinNhanVien();
        nhanViens.add(nhanVien);
        System.out.println("Bạn đã thêm thành công");
        WriteFileModule2.writeFileNhanVien(NHAN_VIEN_FILE, nhanViens);
    }

    @Override
    public void hienThiNhanVien() throws IOException {
        nhanViens = ReadFileModule2.readFileNhanVien(NHAN_VIEN_FILE);
        for (NhanVien nhanVien : nhanViens) {
            System.out.println(nhanVien);
        }
    }

    @Override
    public void xoaNhanVien() throws IOException {
        nhanViens = ReadFileModule2.readFileNhanVien(NHAN_VIEN_FILE);
        String id;
        int choice;
        boolean check = false;
        hienThiNhanVien();
        if (nhanViens.isEmpty()) {
            System.out.println("Danh sách hiện tại không có nhân viên nào. Hãy thêm nhân viên mới xóa được");
        } else {
            while (true) {
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Mời bạn nhập vào Mã Số Nhân Viên muốn xóa khỏi danh sách (NV-XXX)");
                id = scanner.nextLine();
                for (int i = 0; i < nhanViens.size(); i++) {
                    if (nhanViens.get(i).getMaDinhDanh().equals(id)) {
                        System.out.println("Bạn có chắc chắn muốn xóa thông tin nhân viên có ID là " + nhanViens.get(i).getMaDinhDanh() + " không?");
                        System.out.println("1. Có");
                        System.out.println("2. Không");
                        choice = Integer.parseInt(scanner.nextLine());
                        if (choice == 1) {
                            nhanViens.remove(i);
                            System.out.println("Bạn đã xóa thành công");
                            WriteFileModule2.writeFileNhanVien(NHAN_VIEN_FILE, nhanViens);
                            check = true;
                            return;
                        } else if (choice == 2) {
                            return;
                        }
                    }
                }
                if (!check) {
                    System.out.println("ID bạn nhập không tồn tại. Vui lòng kiểm tra lại!");
                }
            }
        }
    }

    public static NhanVien thongTinNhanVien() throws IOException {
        System.out.println("---------------------------------------------------------");
        System.out.println("Mời bạn nhập vào thông tin để thêm mới cho nhân viên: ");
        NhanVien nhanVien = NhapThongTinNhanVien.nhapThongTinNhanVien();
        return nhanVien;
    }
}
