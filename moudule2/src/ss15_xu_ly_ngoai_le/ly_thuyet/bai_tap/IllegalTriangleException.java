package ss15_xu_ly_ngoai_le.ly_thuyet.bai_tap;

public class IllegalTriangleException extends Exception {
    private String tinNhan;

    public IllegalTriangleException(String message) {
        super(message);
        this.tinNhan = tinNhan;
    }

    public String getTinNhan() {
        return tinNhan;
    }
}
