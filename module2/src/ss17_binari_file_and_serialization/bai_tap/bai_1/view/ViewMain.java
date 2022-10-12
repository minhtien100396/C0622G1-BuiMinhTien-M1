package ss17_binari_file_and_serialization.bai_tap.bai_1.view;

import ss17_binari_file_and_serialization.bai_tap.bai_1.controller.ProductController;

import java.io.IOException;

public class ViewMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ProductController productController = new ProductController();
        productController.productManager();
    }
}
