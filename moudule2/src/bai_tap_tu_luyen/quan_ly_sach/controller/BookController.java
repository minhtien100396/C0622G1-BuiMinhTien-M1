package bai_tap_tu_luyen.quan_ly_sach.controller;

import bai_tap_tu_luyen.quan_ly_sach.service.IBookService;
import bai_tap_tu_luyen.quan_ly_sach.service.IFictionBookService;
import bai_tap_tu_luyen.quan_ly_sach.service.IProgrammingBookService;
import bai_tap_tu_luyen.quan_ly_sach.service.iplm.BookService;
import bai_tap_tu_luyen.quan_ly_sach.service.iplm.FictionBookService;
import bai_tap_tu_luyen.quan_ly_sach.service.iplm.ProgrammingBookService;

import java.util.Scanner;

public class BookController {
    public static void quanLySach() {
        Scanner scanner = new Scanner(System.in);
        IFictionBookService fictionBookService = new FictionBookService();
        IProgrammingBookService programmingBookService = new ProgrammingBookService();
        IBookService bookService= new BookService();
        while (true) {
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với ứng dụng quản lý sách");
            System.out.println("1. Thêm Sách");
            System.out.println("2. Hiển thị Sách");
            System.out.println("3. Tính tổng số tiền");
            System.out.println("4. Đếm số sách ProgrammingBook có langue là Java");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("Hãy nhập lựa chon của bạn");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Bạn muốn thêm sách loại nào");
                    System.out.println("1. ProgeammingBook");
                    System.out.println("2. FictionBook");
                    System.out.println("3.Exit");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            programmingBookService.taoSach();
                            break;
                        case 2:
                            fictionBookService.taoSach();
                            break;
                        case 3:
                            return;
                    }
                    break;
                case 2:
                    System.out.println("Bạn muốn hiển thị sách loại nào");
                    System.out.println("1. ProgeammingBook");
                    System.out.println("2. FictionBook");
                    System.out.println("3. Hiển thị tất cả");
                    System.out.println("4.Exit");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice){
                        case 1:
                            programmingBookService.hienThiProgammingBook();
                            break;
                        case 2:
                            fictionBookService.hienThiFictionBook();
                            break;
                        case 3:
                            bookService.hienThi();
                            break;
                        case 4:
                            return;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;

            }
        }
    }
}
