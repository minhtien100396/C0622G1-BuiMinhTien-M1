package ss12_map_tree_comparator_comparable.bai_tap.bai_1.service.impl;

import ss12_map_tree_comparator_comparable.bai_tap.bai_1.model.Produce;
import ss12_map_tree_comparator_comparable.bai_tap.bai_1.service.IProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static List<Produce> produceList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    static {
        produceList.add(new Produce(1, "Bánh", 20000));
        produceList.add(new Produce(2, "Kẹo", 10000));
        produceList.add(new Produce(3, "Sữa", 30000));
    }

    @Override
    public void addProduct() {

            produceList.add(infoProduct());
            System.out.println("Bạn đã thêm sản phẩm thành công");
            System.out.println("Danh sách các sản phẩm trong kho");
            disPlayProduct();

    }

    @Override
    public void disPlayProduct() {
        if (produceList.size() <= 0) {
            System.out.println("Trong kho chưa có sản phẩm. Hãy thêm sản phẩm vào");
            return;
        }
        for (Produce produce : produceList) {
            System.out.println(produce);
        }
    }

    @Override
    public void removeProduct() {
        if (produceList.size() <= 0) {
            System.out.println("Trong kho chưa có sản phẩm. Hãy thêm sản phẩm vào");
            return;
        }
        Produce produce = this.findProduct();
        if (produce == null) {
            System.out.println("ID bạn nhập không hợp lệ");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa sản phẩm có ID là " + produce.getId() + " không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                produceList.remove(produce);
                System.out.println("Bạn đã xóa sản phẩm có ID là " + produce.getId() + " thành công");
                System.out.println("Danh sách sản phẩm sau khi xóa");
                disPlayProduct();
            }
        }

    }

    @Override
    public void findProductName() {
        if (produceList.size() <= 0) {
            System.out.println("Trong kho chưa có sản phẩm. Hãy thêm sản phẩm vào");
            return;
        }
        System.out.println("Hãy nhập tên sản phẩm bạn muốn tìm kiếm");
        String name = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < produceList.size(); i++) {
            if (produceList.get(i).getName().equalsIgnoreCase(name)) {
                System.out.println("Thông tìn sản phẩm bạn cần tìm kiếm là:");
                System.out.println(produceList.get(i));
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Sản phẩm bạn cần tìm kiếm không tồn tại");
        }

    }

    @Override
    public void sortUpAscending() {
        Comparator<Produce> comparator = new Comparator<Produce>() {
            @Override
            public int compare(Produce o1, Produce o2) {
                if (o1.getPrice() > o2.getPrice()) return 1;
                if (o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            }
        };
        produceList.sort(comparator);
        System.out.println("Sản phẩm đã đươc sắp xếp theo thứ tự giá tăng dần");
        disPlayProduct();
    }

    @Override
    public void sortDescending() {
        Comparator<Produce> comparator = new Comparator<Produce>() {
            @Override
            public int compare(Produce o1, Produce o2) {
                if (o1.getPrice() > o2.getPrice()) return -1;
                if (o1.getPrice() < o2.getPrice()) return 1;
                return 0;
            }
        };
        produceList.sort(comparator);
        System.out.println("Sản phẩm đã đươc sắp xếp theo thứ tự giá giảm dần");
        disPlayProduct();
    }

    @Override
    public void editProduct() {
        Produce produce = this.findProduct();
        if (produce == null) {
            System.out.println("ID bạn nhập không hợp lệ");
        } else {
            System.out.println("Bạn muốn thay đổi thông tin nào");
            System.out.println("1. Mã sản phẩm");
            System.out.println("2. Tên Sản phẩm");
            System.out.println("3. Giá sản phẩm");
            System.out.println("4. Thay đổi toàn bộ thông tin");
            System.out.println("Hãy nhập lựa chọn của bạn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Bạn có chắc chắn muốn thay đổi sản phẩm có ID " + produce.getId() + " Không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    if (choice2 == 1) {
                        System.out.println("Mời bạn nhập vào mã sản phẩm mới");
                        int newID = Integer.parseInt(scanner.nextLine());
                        produce.setId(newID);
                        System.out.println("Bạn đã thay đổi Mã Sản Phẩm Thành Công");
                        System.out.println("Danh sách sản phẩm sau khi thay đổi");
                        disPlayProduct();
                    }
                    break;
                case 2:
                    System.out.println("Bạn có chắc chắn muốn thay đổi tên cho sản phẩm có ID là " + produce.getId() + " Không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    if (choice1 == 1) {
                        System.out.println("Mời bạn nhập vào tên sản phẩm mới");
                        String newName = scanner.nextLine();
                        produce.setName(newName);
                        System.out.println("Bạn đã thay đổi Tên Sản Phẩm Thành Công");
                        System.out.println("Danh sách sản phẩm sau khi thay đổi");
                        disPlayProduct();
                    }
                    break;
                case 3:
                    System.out.println("Bạn có chắc chắn muốn thay giá cho đổi sản phẩm có ID " + produce.getId() + " Không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    if (choice3 == 1) {
                        System.out.println("Mời bạn nhập vào giá cho sản phẩm mới");
                        double newPrice = Integer.parseInt(scanner.nextLine());
                        produce.setPrice(newPrice);
                        System.out.println("Bạn đã thay đổi Giá Sản Phẩm Thành Công");
                        System.out.println("Danh sách sản phẩm sau khi thay đổi");
                        disPlayProduct();
                    }
                    break;
                case 4:
                    System.out.println("Bạn có chắc chắn muốn thay toàn bộ thông tin cho sản phẩm có ID là  " + produce.getId() + " Không?");
                    System.out.println("1. Có");
                    System.out.println("2. Không");
                    int choice4 = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < produceList.size(); i++) {
                        if (choice4 == 1) {
                            System.out.println("Mời bạn nhập vào thông tin cho sản phẩm mới");
                            produceList.set(i, this.infoProduct());
                            System.out.println("Bạn đã thay đổi thông tin Sản Phẩm Thành Công");
                            System.out.println("Danh sách sản phẩm sau khi thay đổi");
                            disPlayProduct();
                            break;
                        }
                    }
            }
        }
    }

    public Produce findProduct() {
        System.out.println("Hãy nhập ID bạn muốn thao tác");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < produceList.size(); i++) {
            if (produceList.get(i).getId() == id) {
                return produceList.get(i);
            }
        }
        return null;
    }

    public Produce infoProduct() {
        System.out.println("Mời bạn nhập vào id cho sản phẩm");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập vào tên của sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập vào giá cho sản phẩm");
        double price = Double.parseDouble(scanner.nextLine());
        Produce produce = new Produce(id, name, price);
        return produce;
    }
}
