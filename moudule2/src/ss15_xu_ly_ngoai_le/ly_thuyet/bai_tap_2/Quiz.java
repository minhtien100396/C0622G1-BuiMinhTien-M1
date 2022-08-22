package ss15_xu_ly_ngoai_le.ly_thuyet.bai_tap_2;

public class Quiz {
    public static void main(String[] args) {
        try {
            int arr[] = new int[5];
            arr[5] = 4;
            System.out.println("arr[5] = " + arr[5]);
        } catch (NullPointerException ex) {
            System.out.println(ex);
        } finally {
            System.out.println("Khối lệnh finally luôn được thực thi");
        }

        System.out.println("Finished!");
    }
}


