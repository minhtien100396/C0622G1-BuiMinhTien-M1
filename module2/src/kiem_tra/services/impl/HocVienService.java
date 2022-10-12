package kiem_tra.services.impl;

import kiem_tra.models.HocVien;
import kiem_tra.services.IHocVienService;
import kiem_tra.utils.read_and_write.ReadFileModule2;
import kiem_tra.utils.read_and_write.WriteFileModule2;
import kiem_tra.utils.validate.NhapThongTinHocVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HocVienService implements IHocVienService {
    private static List<HocVien> hocViens = new ArrayList<>();
    private final String HOC_VIEN_FILE = "src\\kiem_tra\\data\\hoc_vien.csv";

    @Override
    public void themMoiHocVien() throws IOException {
        hocViens = ReadFileModule2.readFileHocVien(HOC_VIEN_FILE);
        HocVien hocVien = this.thongTinHocVien();
        hocViens.add(hocVien);
        System.out.println("Bạn đã thêm thành công");
        WriteFileModule2.writeFileHocVien(HOC_VIEN_FILE, hocViens);
    }

    @Override
    public void hienThiHocVien() throws IOException {
        hocViens = ReadFileModule2.readFileHocVien(HOC_VIEN_FILE);
        for (HocVien hocVien : hocViens) {
            System.out.println(hocVien);
        }
    }

    public static HocVien thongTinHocVien() throws IOException {
        System.out.println("---------------------------------------------------------");
        System.out.println("Mời bạn nhập vào thông tin để thêm mới cho học viên: ");
        HocVien hocVien = NhapThongTinHocVien.nhapThongTinHocVien();
        return hocVien;
    }
}
