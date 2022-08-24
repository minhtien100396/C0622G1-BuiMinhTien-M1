package ss17_binari_file_and_serialization.bai_tap.bai_1.service.impl;

import ss17_binari_file_and_serialization.bai_tap.bai_1.model.Product;
import ss17_binari_file_and_serialization.bai_tap.bai_1.service.IProduceService;
import ss17_binari_file_and_serialization.bai_tap.bai_1.utils.read_and_write.ReadFile;
import ss17_binari_file_and_serialization.bai_tap.bai_1.utils.read_and_write.WriteFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProduceService implements IProduceService {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private static final String PATH_FILE = "src\\ss17_binari_file_and_serialization\\bai_tap\\bai_1\\utils\\data\\product.dat";

    @Override
    public void addProduce() throws IOException, ClassNotFoundException {
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng thêm mới");
        products.add(infoProduce());
        System.out.println("Bạn đã thêm thành công");
        WriteFile.writeFileProduce(PATH_FILE, products);
        products = ReadFile.readFileProduct(PATH_FILE);
    }

    @Override
    public void displayProduce() throws IOException, ClassNotFoundException {
        products = ReadFile.readFileProduct(PATH_FILE);
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng hiển thị");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Bạn đã hiển thị thành công");
    }

    @Override
    public void searchProduce() throws IOException, ClassNotFoundException {
        products = ReadFile.readFileProduct(PATH_FILE);
        System.out.println("------------------------------------------------");
        System.out.println("Chào mừng bạn đến với chức năng tìm kiếm");
        System.out.println("Nhập vào id bạn muốn tìm kiếm");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                System.out.println("Thông tin sản phẩm có id là " + product.getId() + " :");
                System.out.println(product);
            } else {
                System.out.println("Sản phẩm bạn cần tìm không có trong danh sách sản phẩm");
            }
        }
    }

    public Product infoProduce() {
        System.out.println("Hãy nhập vào mã sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập vào tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Hãy nhập vào hãng sản xuất");
        String productCompany = scanner.nextLine();
        System.out.println("Hãy nhập vào giá sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(id, name, productCompany, price);
        return product;
    }

}
