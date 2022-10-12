package bai_tap_tu_luyen.quan_ly_sach.service.iplm;

import bai_tap_tu_luyen.quan_ly_sach.model.Book;
import bai_tap_tu_luyen.quan_ly_sach.model.FictionBook;
import bai_tap_tu_luyen.quan_ly_sach.model.ProgrammingBook;
import bai_tap_tu_luyen.quan_ly_sach.service.IBookService;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    List<Book> books = new ArrayList<>();
    @Override
    public void hienThi() {
        books.add(new FictionBook(1, "b",2,"2","2"));
        books.add(new ProgrammingBook(1, "b",2,"2","2","2"));
        for (Book book:books) {
            System.out.println(book);
        }
    }
}
