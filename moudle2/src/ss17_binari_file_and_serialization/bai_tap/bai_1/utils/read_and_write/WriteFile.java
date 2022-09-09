package ss17_binari_file_and_serialization.bai_tap.bai_1.utils.read_and_write;

import ss17_binari_file_and_serialization.bai_tap.bai_1.model.Product;

import java.io.*;
import java.util.List;

public class WriteFile {
    public static void writeFileProduce(String path, List<Product> productList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(productList);
        objectOutputStream.close();
    }
}
