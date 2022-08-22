package ss16_text_file.luyen_tap.demo;

import java.io.*;

public class ReadAndWriteToCSV {
    public static void main(String[] args) {
        /**
         * Tạo mới đối tượng file
         * pathname: đường dẫn file
         */
        File file = new File("src\\ss16_text_file\\luyen_tap\\data\\file.txt");

        /**
         * Tạo ra một đối tượng dùng để viết file
         * FileWriter(): Có 2 constructor
         * FileWriter(file): truyền vào 1 cái file được định nghĩa ở line 12  có cung cấp đường dẫn
         * FileWriter(đường dẫn): truyền vào trực tiếp 1 đường dẫn
         * Lúc khởi tạo sẽ ném ra 1 exception kiểu compile => phải handle  => try/cactch or throws
         * Để nâng cao hiệu quả ta dùng BufferedWrite.
         */
        try {
            /**
             * FileWriter(file,append):
             * file: file truyền vào
             * append: true: cho phép ghi tiếp. Nếu flase : ghi đè
             * Mặc định không truyền append  thì append = false FileWriter(file)
             */
            //FileWriter fileWriter = new FileWriter(file);
            FileWriter fileWriter1 = new FileWriter(file, true);
            /**
             * BufferedWriter(fileWriter): có tham số là đối tượng được tạo ra ở line 25
             */
            //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
            /**
             *bufferedWriter.write(): Để ghi vào file.
             * Nếu thay từ Hello bằng World thì nó ghi đè
             */
            //bufferedWriter.write("Hello");
            //bufferedWriter.write("World");
            bufferedWriter1.write("Hello World2");
            /**
             * newLine():Ghi xuống hàng
             */
            bufferedWriter1.newLine();
            /**
             * Sau khi ghi xong thì bắt buộc phải đóng lại thì những thằng trên cũng tự đóng lại
             * bufferedWriter.close(): đóng file
             */
            bufferedWriter1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * Tạo file Reader
         */

        try {
            /**
             * Khi đọc thì không có append
             * Chỉ có ghi thì mới có append
             */
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            /**
             * readLine(): Đọc trên 1 dòng
             * Khi đọc bufferedReader.readLine() sẽ trả về chuỗi String => phải gán vào biến String để sout

             */
//            String line = bufferedReader.readLine();
//            System.out.println(line);
            /**
             * Để đọc trên nhiều dòng
             * B1: Tạo chuỗi rỗng
             * B2: Dùng vòng lặp while
             */

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
