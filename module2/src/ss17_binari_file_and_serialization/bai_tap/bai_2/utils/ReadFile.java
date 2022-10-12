package ss17_binari_file_and_serialization.bai_tap.bai_2.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadFile {
    public static List<Object> readFile(String path) throws IOException, ClassNotFoundException {
        List<Object> objectList = null;
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("Tệp tin nguồn không tồn tại.");
            System.exit(0);
        } else {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objectList = (List<Object>) objectInputStream.readObject();
            objectInputStream.close();
        }
        return objectList;
    }

}
