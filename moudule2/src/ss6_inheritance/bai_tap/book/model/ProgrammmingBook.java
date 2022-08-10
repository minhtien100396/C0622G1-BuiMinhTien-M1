package ss6_inheritance.bai_tap.book.model;

public class ProgrammmingBook extends Book {
    private String language;
    private String framework;

    public ProgrammmingBook() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public ProgrammmingBook(String language, String framework) {
        this.language = language;
        this.framework = framework;
    }

    public ProgrammmingBook(String code, String name, double price, String author, String language, String framework) {
        super(code, name, price, author);
        this.language = language;
        this.framework = framework;
    }
}
