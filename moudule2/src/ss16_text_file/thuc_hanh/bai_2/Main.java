package ss16_text_file.thuc_hanh.bai_2;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH_FILE = "src\\ss16_text_file\\thuc_hanh\\bai_2\\data\\numbers.txt";

    public static void main(String[] args) throws IOException {
        List<Integer> list = ReadAndWriteFile.fileRead(PATH_FILE);
        int maxValue = ReadAndWriteFile.findMax(list);
        ReadAndWriteFile.fileWriter("src\\ss16_text_file\\thuc_hanh\\bai_2\\data\\result.txt",maxValue);

    }
}
