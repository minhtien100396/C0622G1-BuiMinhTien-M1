package ss1_introduction_to_java.luyen_tap;

public class ChuKiTu {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9},
                b = new int[3];

        a[9] = b[0];

        System.out.println(a[9]);
    }
}
