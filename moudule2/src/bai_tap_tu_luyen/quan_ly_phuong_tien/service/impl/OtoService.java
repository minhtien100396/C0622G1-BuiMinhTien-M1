package bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl;

import bai_tap_tu_luyen.quan_ly_phuong_tien.model.Oto;
import bai_tap_tu_luyen.quan_ly_phuong_tien.model.PhuongTienGiaoThong;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IOtoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OtoService implements IOtoService {
    private Scanner scanner = new Scanner(System.in);
    public List<Oto> otos = new ArrayList<>();
    public List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();

    @Override
    public void themMoiOTo() {
        Oto oto = this.thongTinOto();
        otos.add(oto);
        System.out.println("Bạn đã thêm thành công");
        phuongTienGiaoThongs.add(oto);
    }

    @Override
    public void hienThiOto() {
        for (Oto oto : otos) {
            System.out.println(oto);
        }
    }

    @Override
    public void xoaOto() {
        Oto oto = this.timOto();
        if (oto == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println("Bạn có chắc chắn xóa");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                otos.remove(oto);
                System.out.println("Bạn đã xóa thành công");
            }
        }
    }

    @Override
    public void timKiemOto() {
        Oto oto = this.timOto();
        if (oto == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println(oto.toString());
            }
        }

    public Oto thongTinOto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào biển kiểm soát");
        String bienKiemSoat = scanner.nextLine();
        for (int i = 0; i < phuongTienGiaoThongs.size(); i++) {
            while (phuongTienGiaoThongs.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                bienKiemSoat = scanner.nextLine();
                if (phuongTienGiaoThongs.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                    System.out.println("Biển Kiểm Soát đã có người sở hữu hãy nhập lại");
                }
            }

        }
        System.out.println("Mời bạn nhập thông tin hãng sản xuất");
        System.out.println(" Mời bạn nhập vào mã sản xuất");
        int maSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Mời bạn nhập vào hãng sản xuất");
        String tenHangSanXuat = scanner.nextLine();
        System.out.println(" Mời bạn nhập vào quốc gia sản xuất");
        String quocGiaSanXuat = scanner.nextLine();
        System.out.println("Mời bạn nhập vào năm sản xuất");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào chủ sở hữu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Mời bạn nhập vào số lượng chỗ ngồi");
        int soLuongChoNgoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào kiểu xe");
        String kieuXe = scanner.nextLine();
        Oto oto = new Oto(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, soLuongChoNgoi, kieuXe);
        return oto;
    }

    public Oto timOto() {
        System.out.println("Nhập vào biển kiểm soát bạn cần xủ lý");
        String bienKiemSoat = scanner.nextLine();
        for (int i = 0; i < otos.size(); i++) {
            if (otos.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                return otos.get(i);
            }
        }
        return null;
    }
}
