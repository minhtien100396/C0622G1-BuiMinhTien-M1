package ss6_inheritance.bai_tap.book.controller;

import ss6_inheritance.bai_tap.book.model.Book;
import ss6_inheritance.bai_tap.book.model.FictionBook;
import ss6_inheritance.bai_tap.book.model.ProgrammmingBook;

public class MainController {
    public static void main(String[] args) {
        //Ép kiểu từ kiểu con lên kiểu cha dùng để quản lý một list kiểu cha
        Book[] books = new Book[4];
        books[0] = new ProgrammmingBook("C01", "Java1", 12, "TG1", "Java", "None");
        books[1] = new ProgrammmingBook("C02", "Java2", 15, "TG2", "Java1", "Levender");
        books[2] = new FictionBook("C03", "Những kẻ xuất chúng", 20, "TG3", "edu");
        books[3] = new FictionBook("C04", "Câu chuyện từ trái tim", 25, "TG4", "fun");

        int sum = getTinhTong(books);
        System.out.println(sum);
        //Đếm số sách có language là Java
        //Duyệt mảng
        //NẾu là programingBook thì kiểm tra xem languege của nó là bao nhiêu
        //Có bằng Java hay không?
        int count = getDemSoSach(books, "Java");
        System.out.println("Số sách có langua là Java là: " + count);
    }


    public static int getTinhTong(Book[] books) {
        int sum = 0;
        for (int i = 0; i < books.length; i++) {
            sum += books[i].getPrice();
        }
        return sum;
    }


    public static int getDemSoSach(Book[] books, String langue) {
        int count = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] instanceof ProgrammmingBook) {
                if (((ProgrammmingBook) books[i]).getLanguage().equals(langue)) {
                    count++;
                }
            }
        }
        return count;
    }
}
