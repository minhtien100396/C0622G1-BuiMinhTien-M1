package ss1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class SuDungToanTu {
    /*
    Viết một ứng dụng để tính diện tích của hình chữ nhật dựa vào chiều rộng và chiều cao được nhập vào.
    */
    public static void main(String[] args) {
        //Tự tạo riêng đối tượng Scanner
        /*System.out.println("Hãy nhập chiều rộng của hình chữ nhật");
        float chieuRong = new Scanner(System.in).nextFloat();
        System.out.println("Hãy nhập chiều dài của hình chữ nhật");
        float chieuDai = new Scanner(System.in).nextFloat();
        System.out.println("Diện tích của hình chữ nhật là: " + chieuDai * chieuRong);*/


        //Tạo đối tượng Scanner và Nhập dữ liệu Scanner riêng biệt

        // Tạo đối tượng Scanner để nhập dữ liệu từ bàn phím
        Scanner khaibao = new Scanner(System.in);
        System.out.println("hãy nhập chiều rộng");
        // Nhập dữ liệu từ Scanner
        float chieuRong = khaibao.nextFloat();
        System.out.println("hãy nhập chiều dài");
        float chieuDai = khaibao.nextFloat();
        System.out.println("Diện tích là: " + chieuDai * chieuRong);
    }
}
