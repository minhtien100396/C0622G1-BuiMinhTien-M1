package kiem_tra.controllers;

import case_study.task_1.services.*;
import case_study.task_1.services.impl.*;
import case_study.task_1.utils.exception.ChoiceException;
import kiem_tra.services.IHocVienService;
import kiem_tra.services.INhanVienService;
import kiem_tra.services.impl.HocVienService;
import kiem_tra.services.impl.NhanVienService;

import java.io.IOException;
import java.util.Scanner;

public class NhanSuController {
    public static void quanLyNhanSu() {
        Scanner scanner = new Scanner(System.in);
        IHocVienService hocVienService = new HocVienService();
        INhanVienService nhanVienService = new NhanVienService();
        while (true) {
            System.out.println("------------------------------------");
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ NHÂN SỰ--");
            System.out.println("Chọn chức năng theo số (để tiếp tục):");
            System.out.println("1. Thêm Mới Nhân Sự");
            System.out.println("2. Xóa Nhân SỰ");
            System.out.println("3. Xem Danh Sách Nhân Sự");
            System.out.println("4. Thoát");
            System.out.println("Chọn chức năng");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new ChoiceException("Hãy nhập lựa chọn có trong MENU");
                } else {
                    switch (choice) {
                        case 1:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("Chọn loại nhân sự cần thêm");
                                System.out.println("1. Thêm mới nhân viên");
                                System.out.println("2. Thêm mới học viên");
                                System.out.println("3. Quay lại");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Chọn chức năng");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 3) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU THÊM MỚI NHÂN SỰ");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                nhanVienService.themMoiNhanVien();
                                                check = true;
                                                break;
                                            case 2:
                                                hocVienService.themMoiHocVien();
                                                check = true;
                                                break;
                                            case 3:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 2:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("Chọn loại nhân sự cần xóa");
                                System.out.println("1. Xóa nhân viên");
                                System.out.println("2. Xóa  học viên");
                                System.out.println("3. Quay lại");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Chọn chức năng");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 3) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU XÓA NHÂN SỰ");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                nhanVienService.xoaNhanVien();
                                                check = true;
                                                break;
                                            case 2:
                                                hocVienService.themMoiHocVien();
                                                check = true;
                                                break;
                                            case 3:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 3:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("Chọn loại nhân sự cần hiển thị");
                                System.out.println("1. Hiển thị nhân viên");
                                System.out.println("2. Hiển thị học viên");
                                System.out.println("3. Quay lại");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Chọn chức năng");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 3) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU HIỂN THỊ NHÂN SỰ");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                nhanVienService.hienThiNhanVien();
                                                check = true;
                                                break;
                                            case 2:
                                                hocVienService.hienThiHocVien();
                                                check = true;
                                                break;
                                            case 3:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 4:
                            while (true) {
                                System.out.println("------------------------------------");
                                System.out.println("MENU BOOKING MANAGEMENT");
                                System.out.println("1. Add new booking");
                                System.out.println("2. Display list booking");
                                System.out.println("3. Create new constracts");
                                System.out.println("4. Display list contracts");
                                System.out.println("5. Edit contracts");
                                System.out.println("6. Return main menu");
                                boolean check = false;
                                int choice1;
                                try {
                                    System.out.println("Hãy nhập lựa chọn của bạn ");
                                    choice1 = Integer.parseInt(scanner.nextLine());
                                    if (choice1 < 1 || choice1 > 6) {
                                        throw new ChoiceException("Hãy nhập lựa chọn có trong MENU BOOKING MANAGEMENT");
                                    } else {
                                        switch (choice1) {
                                            case 1:
                                                check = true;
                                                break;
                                            case 2:
                                                check = true;
                                                break;
                                            case 3:
                                                check = true;
                                                break;
                                            case 4:
                                                check = true;
                                                break;
                                            case 5:
                                                check = true;
                                                break;
                                            case 6:
                                                break;
                                        }
                                    }
                                } catch (ChoiceException e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                } catch (NumberFormatException e) {
                                    System.out.println("Lựa chọn của bạn không hợp lệ. Hãy kiểm tra lại");
                                    check = true;
                                }
                                if (!check) {
                                    break;
                                }
                            }
                            break;
                        case 5:
                            System.out.println("------------------------------------");
                            System.out.println("MENU PROMOTION  MANAGEMENT");
                            System.out.println("1. Display list customers use service");
                            System.out.println("2. Display list customers get voucher");
                            System.out.println("3. Return main menu");
                            System.out.println("Hãy nhập lựa chọn của bạn ");
                            int choice5 = Integer.parseInt(scanner.nextLine());
                            if (choice5 < 1 || choice5 > 3) {
                                System.out.println("Hãy nhập lựa chọn có trong MENU PROMOTION MANAGEMENT");
                            } else {
                                switch (choice5) {
                                    case 1:
                                        break;
                                    case 2:
                                        break;
                                    case 3:
                                        break;
                                }
                                break;
                            }
                            break;
                        case 6:
                            System.out.println("Cám ơn bạn đã sử dụng ứng dụng");
                            return;
                    }
                }
            } catch (ChoiceException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Hãy nhập đúng lựa chọn trên menu");
            }
        }
    }
}
