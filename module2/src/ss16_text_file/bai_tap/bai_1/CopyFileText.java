package ss16_text_file.bai_tap.bai_1;

import java.io.IOException;
import java.util.List;

public class CopyFileText {
    private static final String PATH_FILE = "src\\ss16_text_file\\bai_tap\\bai_1\\data\\source_file.txt";

    public static void main(String[] args) throws IOException {
        List<String> list = ReadAndWriteFile.readFile(PATH_FILE);
        for (String line : list) {
            ReadAndWriteFile.writerFile("src\\ss16_text_file\\bai_tap\\bai_1\\data\\target_file.txt", line);
        }
        System.out.println("Số lượng phần tử trong mảng là: "+ReadAndWriteFile.ShowNumberOfCharacters(list));
    }

}
