package ss16_text_file.bai_tap.bai_2.data;

import java.util.List;

public class MainCSV {
    public static void main(String[] args) {
        List<String> list = ReadFile.readFile("src\\ss16_text_file\\bai_tap\\bai_2\\data\\text.txt");
        for (String line : list) {
            System.out.println(line);
        }
    }
}
