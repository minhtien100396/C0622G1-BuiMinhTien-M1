package ss4_lop_va_doi_tuong_trong_java.luyen_tap;

public class VeHinhThoi {
    public static void main(String[] args) {
        String str = "";
        for (int i = 1; i <= 5; i++) {
            for (int k = 5 - i; k > 0; k--) {
                str += " ";
            }
            str += i;
            for (int j = 1; j <= 2 * i - 1; j++) {
                str += " ";
            }
            str += i + "\n";
        }

        for (int i = 4; i >= 1; i--) {
            for (int k = 5 - i; k > 0; k--) {
                str += " ";
            }
            str += i;
            for (int k = 2 * i - 1; k > 0; k--) {
                str += " ";
            }
            str += i + "\n";
        }

        System.out.println(str);
    }
}
