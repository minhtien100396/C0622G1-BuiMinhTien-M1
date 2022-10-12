package ss6_inheritance.bai_tap.book.model;

public class FictionBook extends Book {
    private String caterogy;

    public FictionBook(String code, String name, double price, String author, String caterogy) {
        super(code, name, price, author);
        this.caterogy = caterogy;
    }

    public FictionBook(String caterogy) {
        this.caterogy = caterogy;
    }

    public FictionBook() {
    }

    public String getCaterogy() {
        return caterogy;
    }

    public void setCaterogy(String caterogy) {
        this.caterogy = caterogy;
    }
}
