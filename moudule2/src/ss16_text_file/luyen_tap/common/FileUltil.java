package ss16_text_file.luyen_tap.common;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUltil {
    public static void main(String[] args) {

    }
    public static void writerFile(String pathFile,String line){
        try {
            FileWriter  fileWriter = new FileWriter(pathFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();


            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String pathFile){
        List<String> listLine = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //line để lưu từng line mà chúng ta đi qua.
            String line = null;
            while ((line = bufferedReader.readLine())!=null){
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listLine;
    }
}
