package bai_tap_tu_luyen.quan_ly_phuong_tien.controller;

import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IOtoService;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IXeMayService;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.IXeTaiService;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl.OtoService;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl.XeMayService;
import bai_tap_tu_luyen.quan_ly_phuong_tien.service.impl.XeTaiService;

import java.util.Scanner;

public class MainController {
    public void quanLyPhuongTien() {
        Scanner scanner = new Scanner(System.in);
        IOtoService otoService = new OtoService();
        IXeTaiService xeTaiService = new XeTaiService();
        IXeMayService xeMayService = new XeMayService();
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với phần mềm quản lý phương tiện giao thông");
            System.out.println("1. Thêm mới phương tiện");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Tìm kiếm theo biển kiểm soát");
            System.out.println("5.Thoát");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Chào mừng bạn đến với chức năng Thêm Mới");
                    System.out.println("1. Thêm mới Oto");
                    System.out.println("2. Thêm mới xe tải");
                    System.out.println("3. Thêm mới xe máy");
                    System.out.println("4. Thoát");
                    System.out.println("-------------------------------------------");
                    System.out.println("Bạn muốn thêm mới phương tiện: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            otoService.themMoiOTo();
                            break;
                        case 2:
                            xeTaiService.themMoiXeTai();
                            break;
                        case 3:
                            xeMayService.themMoiXeMay();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Chào mừng bạn đến với chức năng Hiển thị");
                    System.out.println("1. Hiển thị Oto");
                    System.out.println("2. Hiển thị xe tải");
                    System.out.println("3. Hiển thị xe máy");
                    System.out.println("4. Thoát");
                    System.out.println("-------------------------------------------");
                    System.out.println("Bạn muốn hiển thị phương tiện: ");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            otoService.hienThiOto();
                            break;
                        case 2:
                            xeTaiService.hienThiXeTai();
                            break;
                        case 3:
                            xeMayService.hienThiXeMay();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 3:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Chào mừng bạn đến với chức năng Xóa");
                    System.out.println("1. Xóa Oto");
                    System.out.println("2. Xóa xe tải");
                    System.out.println("3. Xóa xe máy");
                    System.out.println("4. Thoát");
                    System.out.println("-------------------------------------------");
                    System.out.println("Bạn muốn xóa phương tiện: ");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    switch (choice3) {
                        case 1:
                            otoService.xoaOto();
                            break;
                        case 2:
                            xeTaiService.xoaXeTai();
                            break;
                        case 3:
                            xeMayService.xoaXeMay();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 4:
                    System.out.println("--------------------------------------------------");
                    System.out.println("Chào mừng bạn đến với chức năng Tìm Kiếm");
                    System.out.println("1. Tìm kiếm Oto");
                    System.out.println("2. Tìm kiếm xe tải");
                    System.out.println("3. Tìm kiếm xe máy");
                    System.out.println("4. Thoát");
                    System.out.println("-------------------------------------------");
                    System.out.println("Bạn muốn tìm kiếm phương tiện: ");
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    switch (choice4) {
                        case 1:
                            otoService.timKiemOto();
                            break;
                        case 2:
                            xeTaiService.timKiemXeTai();
                            break;
                        case 3:
                            xeMayService.timKiemXeMay();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 5:
                    System.out.println("Cám ơn bạn đã sử dụng phần mềm");
                    return;
            }
        }
    }
}
