package ss16_text_file.bai_tap.bai_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadAndWriteFile {
    public static List<String> readFile(String path) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            list.add(line);
        }
        bufferedReader.close();
        return list;
    }

    public static void writerFile(String path, String line) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(line);
        bufferedWriter.newLine();

        bufferedWriter.close();
    }

    public static int ShowNumberOfCharacters(List<String> list) {
        String str = "";
        for (String line : list) {
            String[] newLine = line.trim().split("");
            for (int i = 0; i < newLine.length; i++) {
                if (newLine[i].equals(" ")) {
                    continue;
                }
                str += newLine[i];
            }
        }
        return str.length();
    }

}
