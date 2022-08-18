package ss15_xu_ly_ngoai_le.ly_thuyet.bai_tap;

public class TamGiac {
    int a, b, c;

    public TamGiac(int a, int b, int c) throws IllegalTriangleException {
        if (a <= 0 || b < 0 || c < 0) {
           throw new IllegalTriangleException("Mày ngáo à");
        }
    }
}
