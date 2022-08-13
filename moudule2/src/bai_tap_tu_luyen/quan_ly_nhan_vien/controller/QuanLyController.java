package bai_tap_tu_luyen.quan_ly_nhan_vien.controller;

import bai_tap_tu_luyen.quan_ly_nhan_vien.service.INhanVienPartTimeService;
import bai_tap_tu_luyen.quan_ly_nhan_vien.service.INhanVienService;
import bai_tap_tu_luyen.quan_ly_nhan_vien.service.eplm.NhanVienPartTimeService;
import bai_tap_tu_luyen.quan_ly_nhan_vien.service.eplm.NhanVienService;

import java.util.Scanner;

public class QuanLyController {
    public void quanLyNhanVien(){
        INhanVienService nhanVienService = new NhanVienService();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("-----------------------------------------");
            System.out.println("Chào mừng bạn đến với ứng dụng quản lý nhân viên");
            System.out.println("1.Hiển thị toàn bộ nhân viên");
            System.out.println("2.Thêm nhân viên mới");
            System.out.println("3. Liệt kê nhân viên FullTime có mức lương thấp hơn mức lương trung bình của các nhân viên trong công ty");
            System.out.println("4. Tính số lương phải trả cho nhân viên PartTime");
            System.out.println("5. Sắp xếp nhân viên theo số lương tăng dần");
            System.out.println("6. Exit");
            System.out.println("Xin mời bạn lựa chọn chức năng");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    nhanVienService.hienThiAll();
                    break;
                case 2:
                    nhanVienService.themNhanVien();
                    break;
                case 3:
                    nhanVienService.lietKeNhanVien();
                    break;
                case 4:
                    nhanVienService.tinhLuong();
                    break;
                case 5:
                    nhanVienService.sapXep();
                    break;
                case 6:
                    return;

            }
        }
    }
}
