package ss12_map_tree_comparator_comparable.bai_tap.bai_1.controller;

import ss12_map_tree_comparator_comparable.bai_tap.bai_1.service.IProductService;
import ss12_map_tree_comparator_comparable.bai_tap.bai_1.service.impl.ProductService;

import java.util.Scanner;

public class ProductManager {
    public static void productManager() {
        Scanner scanner = new Scanner(System.in);
        IProductService productService = new ProductService();
        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("Chào mừng bạn đến với phần mềm quản lý sản phẩm");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo ID");
            System.out.println("3. Xoá sản phẩm theo ID");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp theo giá sản phẩm");
            System.out.println("7. Exit");
            System.out.println("--------------------------------------------------------");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;
                case 2:
                    productService.editProduct();
                    break;
                case 3:
                    productService.removeProduct();
                    break;
                case 4:
                    productService.disPlayProduct();
                    break;
                case 5:
                    productService.findProductName();
                    break;
                case 6:
                    System.out.println("Bạn muốn sắp xếp như thế nào");
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1){
                        case 1:
                            productService.sortUpAscending();
                            break;
                        case 2:
                            productService.sortDescending();
                            break;
                    }
                    break;
                case 7:
                    return;
            }
        }
    }
}
