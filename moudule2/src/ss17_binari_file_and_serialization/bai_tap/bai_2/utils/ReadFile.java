package ss17_binari_file_and_serialization.bai_tap.bai_2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFile {
    public static List<Object> readFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Object> objectList = (List<Object>) objectInputStream.readObject();
        objectInputStream.close();
        return objectList;
    }

}
