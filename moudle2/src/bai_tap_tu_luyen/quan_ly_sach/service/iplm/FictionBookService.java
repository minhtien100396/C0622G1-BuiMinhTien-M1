package bai_tap_tu_luyen.quan_ly_sach.service.iplm;

import bai_tap_tu_luyen.quan_ly_sach.model.FictionBook;
import bai_tap_tu_luyen.quan_ly_sach.service.IFictionBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FictionBookService implements IFictionBookService {
    Scanner scanner = new Scanner(System.in);
    List<FictionBook> fictionBooks = new ArrayList<>();
    @Override
    public void taoSach() {
        fictionBooks.add(this.thongTinFictionBook());
        System.out.println("Bạn đã thêm sách thành công");
    }

    @Override
    public void hienThiFictionBook() {
        for (FictionBook fictionBook:fictionBooks) {
            System.out.println(fictionBook);
        }
    }

    public FictionBook thongTinFictionBook() {
        System.out.println("Mời bạn nhập mã ID cho sách");
        int bookCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên cho sách");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giá sách");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Mời bạn nhập tên tác giá cho sách");
        String author = scanner.nextLine();
        System.out.println("Mời bạn nhập thể loại cho sách");
        String category = scanner.nextLine();
        FictionBook fictionBook = new FictionBook(bookCode, name, price, author, category);
        return fictionBook;
    }
}
