package ss16_text_file.luyen_tap.vi_du_tao_tap_tin_va_thu_muc;

import java.io.File;
import java.io.IOException;

public class ViDuTaoTapTinVaThuMuc {
    public static void main(String[] args) {
        //Lưu ý:
        //MS Window:\=>\\ Ví dụ: "C:\\Thư mục 1\\Thư mục\\Tên tập tin.xxx";
        //Tạo file và cách đặt đường dẫn cho file
        //Kiểm tra thư mục or tập tin có tồn tại hay không?
        File forder1 = new File("src\\ss16_text_file\\luyen_tap\\vi_du_tao_tap_tin_va_thu_muc");
        File forder2 = new File("src\\ss16_text_file\\luyen_tap\\vi_du_tao_tap_tin_va_thu_muc1");
        //Kiểm tra thư mục or tập tin có tồn tại hay không? trả về true or false forder1.exists()
        System.out.println("Kiểm tra foder 1 có tồn tại hay không?\n" + forder1.exists());
        //trả về true
        System.out.println("Kiểm tra foder 1 có tồn tại hay không?\n" + forder2.exists());
        //trả về flase


        //Tạo thư mục
        //C1: phương thức mkdir()  => Tạo 1 thư mục
        File forder3 = new File("src\\ss16_text_file\\luyen_tap\\vi_du_tao_tap_tin_va_thu_muc\\thu_muc");
        forder3.mkdir();


        //C2: phương thực mkdirs() => Tạo ra nhiều thư mục cùng lúc
//        File forder4 = new File("src\\ss16_text_file\\luyen_tap\\vi_du_tao_tap_tin_va_thu_muc\\thu_muc1\\thu_muc2\\thu_muc2\\\thu_muc2");
//        forder4.mkdirs();


        //Tạo tập tin (có phần mở rộng:exe,.txt,.doc,...)
        //Tạo File
        File file1 = new File("src\\ss16_text_file\\luyen_tap\\vi_du_tao_tap_tin_va_thu_muc\\vidu1.txt");
        //phương thước createNewFile();
        try {
            file1.createNewFile();
            file1.createNewFile();
        } catch (IOException e) {
            //Không có quyền tạo tập tin
            //Ổ cứng bị đầy
            //ĐƯờng dẫn bị sai
            e.printStackTrace();
        }
    }
}
