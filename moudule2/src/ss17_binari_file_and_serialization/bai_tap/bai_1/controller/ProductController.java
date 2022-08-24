package ss17_binari_file_and_serialization.bai_tap.bai_1.controller;

import ss17_binari_file_and_serialization.bai_tap.bai_1.service.IProduceService;
import ss17_binari_file_and_serialization.bai_tap.bai_1.service.impl.ProduceService;
import ss17_binari_file_and_serialization.bai_tap.bai_1.utils.OptionException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductController {
    public static void productManager() throws IOException, ClassNotFoundException {
        IProduceService produceService = new ProduceService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("---------------------------------------");
            System.out.println("MENU");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm ");
            System.out.println("3. Tìm kiếm sản phẩm ");
            System.out.println("4. Exit ");
            int choice;
            try {
                System.out.println("Hãy nhập lựa chọn của bạn");
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    throw new OptionException("Hãy nhập lựa chọn chính xác");
                } else {
                    switch (choice) {
                        case 1:
                            produceService.addProduce();
                            break;
                        case 2:
                            produceService.displayProduce();
                            break;
                        case 3:
                            produceService.searchProduce();
                            break;
                        case 4:
                            System.out.println("Cám ơn bạn đã sử dụng phần mềm!");
                            return;
                    }
                }
            } catch (OptionException e) {
                System.out.println(e.getMessage());
            } catch ( NumberFormatException e) {
                System.out.println("Hãy nhập đúng định dạng");
            }
        }

    }
}
