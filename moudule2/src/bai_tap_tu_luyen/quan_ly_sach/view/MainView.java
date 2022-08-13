package bai_tap_tu_luyen.quan_ly_sach.view;

import bai_tap_tu_luyen.quan_ly_sach.controller.BookController;

public class MainView {
    public static void main(String[] args) {
        BookController bookController = new BookController();
        bookController.quanLySach();
    }
}
