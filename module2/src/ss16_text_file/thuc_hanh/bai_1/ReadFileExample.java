package ss16_text_file.thuc_hanh.bai_1;

import java.io.*;

public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\ss16_text_file\\thuc_hanh\\bai_1\\common\\data\\numbers.txt");
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        int sum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            sum += Integer.parseInt(line);
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
