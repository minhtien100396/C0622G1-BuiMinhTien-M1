package ss17_binari_file_and_serialization.bai_tap.bai_1.utils.read_and_write;

import ss17_binari_file_and_serialization.bai_tap.bai_1.model.Product;

import java.io.*;
import java.util.List;

public class ReadFile {
    public static List<Product> readFileProduct(String path) throws IOException, ClassNotFoundException {
        List<Product> productList=null;
        FileInputStream fileInputStream = new FileInputStream(path);

        try {
            if (fileInputStream.available() == 0) {
                throw new EOFException("File hiện tại đang trống");
            } else {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                productList = (List<Product>) objectInputStream.readObject();
                objectInputStream.close();
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        }
        return productList;
    }
}
