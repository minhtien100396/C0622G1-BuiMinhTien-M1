package ss2_vong_lap_trong_java.bai_tap;

public class PrimeDisplay {
    public static void main(String[] args) {
        /*Hiển thị các số nguyên tố nhỏ hơn 100

        Bước 1: Viết mã kiểm tra một số cho trước có phải là số nguyên tố hay không

        Bước 2: Lặp lại việc kiểm tra trên từng số trong khoảng từ 2 tới 100

        Chạy vòng lặp trên các số từ 2 tới 100, kiểm tra mỗi trường hợp có phải là số nguyên tố

        không bằng mã đã thực hiện ở bước 1. In ra màn hình nếu gặp số nguyên tố.
        */
        System.out.println("Hiển thị các số nguyên tố nhỏ hơn 100");
        for (int i = 2; i < 100; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.print(i+" ");
            }
        }
    }
}
