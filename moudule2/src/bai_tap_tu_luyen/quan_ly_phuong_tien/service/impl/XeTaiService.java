package bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl;

import bai_tap_tu_luyen.quan_ly_phuong_tien.model.PhuongTienGiaoThong;
import bai_tap_tu_luyen.quan_ly_phuong_tien.model.XeTai;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IXeTaiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XeTaiService implements IXeTaiService {
    Scanner scanner = new Scanner(System.in);
    public List<XeTai> xeTais = new ArrayList<>();
    public List<PhuongTienGiaoThong> phuongTienGiaoThongs = new ArrayList<>();


    @Override
    public void themMoiXeTai() {
        xeTais.add(this.thongTinXeTai());
        System.out.println("Bạn đã thêm thành công");
        phuongTienGiaoThongs.add(this.thongTinXeTai());
    }

    @Override
    public void hienThiXeTai() {
        for (XeTai xeTai : xeTais) {
            System.out.println(xeTai);
        }
    }

    @Override
    public void xoaXeTai() {
        XeTai xeTai = this.timXeTai();
        if (xeTai == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println("Bạn có chắc chắn xóa");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                xeTais.remove(xeTai);
                System.out.println("Bạn đã xóa thành công");
            }
        }
    }

    @Override
    public void timKiemXeTai() {
        XeTai xeTai = this.timXeTai();
        if (xeTai == null) {
            System.out.println("Biển kiếm soát không tồn tại");
        } else {
            System.out.println(xeTai.toString());
        }
    }


    public XeTai thongTinXeTai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập thông tin hãng sản xuất");
        System.out.println(" Mời bạn nhập vào mã sản xuất");
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
        System.out.println("Mời bạn nhập vào số lượng chỗ ngồi");
        double trongTai = Integer.parseInt(scanner.nextLine());
        XeTai xeTai = new XeTai(maSanXuat, tenHangSanXuat, quocGiaSanXuat, bienKiemSoat, namSanXuat, chuSoHuu, trongTai);
        return xeTai;
    }

    public XeTai timXeTai() {
        System.out.println("Nhập vào biển số xe bạn cần xóa");
        String bienKiemSoat = scanner.nextLine();
        for (int i = 0; i < xeTais.size(); i++) {
            if (xeTais.get(i).getBienKiemSoat().equalsIgnoreCase(bienKiemSoat)) {
                return xeTais.get(i);
            }
        }
        return null;
    }
}
