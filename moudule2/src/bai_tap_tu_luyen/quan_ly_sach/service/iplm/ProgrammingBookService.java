package bai_tap_tu_luyen.quan_ly_sach.service.iplm;

import bai_tap_tu_luyen.quan_ly_sach.model.ProgrammingBook;
import bai_tap_tu_luyen.quan_ly_sach.service.IProgrammingBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgrammingBookService implements IProgrammingBookService {
    Scanner scanner = new Scanner(System.in);
    List<ProgrammingBook> programmmingBooks = new ArrayList<>();

    @Override
    public void taoSach() {
        programmmingBooks.add(this.thongTinProgrammingBook());
        System.out.println("Bạn đã thêm sách thành công");
    }

    @Override
    public void hienThiProgammingBook() {
        for (ProgrammingBook programmingBook : programmmingBooks) {
            System.out.println(programmingBook);
        }
    }

    public ProgrammingBook thongTinProgrammingBook() {
        System.out.println("Mời bạn nhập mã ID cho sách");
        int bookCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên cho sách");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giá sách");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập tên tác giá cho sách");
        String author = scanner.nextLine();
        System.out.println("Mời bạn nhập ngôn ngữ cho sách");
        String language = scanner.nextLine();
        System.out.println("Mời bạn nhập framework cho sách");
        String framework = scanner.nextLine();
        ProgrammingBook programmmingBook = new ProgrammingBook(bookCode, name, price, author, language, framework);
        return programmmingBook;
    }
}
