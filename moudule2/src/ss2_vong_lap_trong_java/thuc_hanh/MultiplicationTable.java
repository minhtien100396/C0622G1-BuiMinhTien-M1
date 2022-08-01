package ss2_vong_lap_trong_java.thuc_hanh;

public class MultiplicationTable {
    public static void main(String[] args) {
        System.out.println("               Bảng cửu chương");
        System.out.print("     ");
        for (int i = 1; i < 10; i++)
            System.out.printf("%4d", i);

        System.out.println("\n------------------------------------------------");
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " |  ");
            for (int j = 1; j < 10; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
