package ss17_binari_file_and_serialization.bai_tap.bai_1.utils.read_and_write;

import ss17_binari_file_and_serialization.bai_tap.bai_1.model.Product;

import java.io.*;
import java.util.List;

public class ReadFile {
    public static List<Product> readFileProduct(String path) throws IOException, ClassNotFoundException {
        List<Product> productList;
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        productList = (List<Product>) objectInputStream.readObject();
        objectInputStream.close();
        return productList;
    }
}
