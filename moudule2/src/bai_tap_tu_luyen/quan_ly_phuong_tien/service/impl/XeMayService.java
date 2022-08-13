package bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl;

import bai_tap_tu_luyen.quan_ly_phuong_tien.model.PhuongTienGiaoThong;
import bai_tap_tu_luyen.quan_ly_phuong_tien.model.XeMay;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IXeMayService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeMayService implements IXeMayService {
    Scanner scanner = new Scanner(System.in);
    public List<XeMay> xeMays = new ArrayList<>();
    public List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();

    @Override
    public void themMoiXeMay() {
        xeMays.add(this.thongTinXeMay());
        System.out.println("Bạn đã thêm thành công");
        phuongTienGiaoThongs.add(this.thongTinXeMay());
    }

    @Override
    public void hienThiXeMay() {
        for (XeMay xeMay : xeMays) {
            System.out.println(xeMay);
        }
    }

    @Override
    public void xoaXeMay() {
        XeMay xeMay = this.timXeMay();
        if (xeMay == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println("Bạn có chắc chắn xóa");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                xeMays.remove(xeMay);
                System.out.println("Bạn đã xóa thành công");
            }
        }
    }

    @Override
    public void timKiemXeMay() {
        XeMay xeMay = this.timXeMay();
        if (xeMay == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println(xeMay.toString());
        }
    }

    public XeMay thongTinXeMay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin hãng sản xuất");
        System.out.println("Mời bạn nhập vào mã sản xuất");
        int maSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println(" Mời bạn nhập vào hãng sản xuất");
        String tenHangSanXuat = scanner.nextLine();
        System.out.println(" Mời bạn nhập vào quốc gia sản xuất");
        String quocGiaSanXuat = scanner.nextLine();
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
        System.out.println("Mời bạn nhập vào năm sản xuất");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào chủ sở hữu");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Mời bạn nhập công suất cho xe");
        double congSuat = Integer.parseInt(scanner.nextLine());
        XeMay xeMay = new XeMay(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, congSuat);
        return xeMay;
    }

    public XeMay timXeMay() {
        System.out.println("Nhập vào biển số xe bạn cần xóa");
        String bienKiemSoat = scanner.nextLine();
        for (int i = 0; i < xeMays.size(); i++) {
            if (xeMays.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                return xeMays.get(i);
            }
        }
        return null;
    }
}
