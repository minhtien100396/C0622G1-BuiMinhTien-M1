package bai_tap_tu_luyen.quan_ly_sach.model;

public class ProgrammingBook extends Book {
    private String language;
    private String framework;

    public ProgrammingBook() {
    }

    public ProgrammingBook(int bookCode, String name, double price, String author, String language, String framework) {
        super(bookCode, name, price, author);
        this.language = language;
        this.framework = framework;
    }

    @Override
    public String toString() {
        return "ProgrammingBook{" +
                super.toString() +
                "language='" + language + '\'' +
                ", framework='" + framework + '\'' +
                '}';
    }
}
