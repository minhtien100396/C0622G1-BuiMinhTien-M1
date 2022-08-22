package ss16_text_file.thuc_hanh.bai_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static List<Integer> fileRead(String pathFile) throws IOException {
        List<Integer> integerList = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            integerList.add(Integer.parseInt(line));

        }
        bufferedReader.close();
        return integerList;
    }

    public static void fileWriter(String path, int max) throws IOException {
        File file = new File(path);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Giá trị lớn nhất là:" + max);
        bufferedWriter.close();
    }

    public static int findMax(List<Integer> number) {
        int max = number.get(0);
        for (int i = 1; i < number.size(); i++) {
            if (number.get(i) > max) {
                max = number.get(i);
            }
        }
        return max;
    }
}
