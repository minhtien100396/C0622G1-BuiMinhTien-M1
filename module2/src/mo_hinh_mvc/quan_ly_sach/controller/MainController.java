package mo_hinh_mvc.quan_ly_sach.controller;

import mo_hinh_mvc.quan_ly_sach.model.Book;
import mo_hinh_mvc.quan_ly_sach.model.FictionBook;
import mo_hinh_mvc.quan_ly_sach.model.ProgrammingBook;

public class MainController {
    public static void main(String[] args) {
        Book[] book = new Book[4];
        book[0] = new FictionBook(1, "anh ", 20, "Tiến", "thiếu nhi");
        book[1] = new FictionBook(2, "em ", 10, "Bia", "thiếu nhi");
        book[2] = new ProgrammingBook(3, "dũng ", 10, "Trường", "java", "truyện");
        book[3] = new ProgrammingBook(4, "NHi ", 5, "Giang", "java", "sách");
        System.out.println(tinhTongGia(book));
        System.out.println(demSoSach(book));
    }

    public static int tinhTongGia(Book[] book) {
        int sum = 0;
        for (int i = 0; i < book.length; i++) {
            sum += book[i].getPrice();
        }
        return sum;
    }

    public static int demSoSach(Book[] book) {
        int count = 0;
        for (int i = 0; i < book.length; i++) {
            if (book[i] instanceof ProgrammingBook) {
                if (((ProgrammingBook) book[i]).getLanguage().equalsIgnoreCase("java")) {
                    count++;
                }
            }
        }
        return count;
    }
}
