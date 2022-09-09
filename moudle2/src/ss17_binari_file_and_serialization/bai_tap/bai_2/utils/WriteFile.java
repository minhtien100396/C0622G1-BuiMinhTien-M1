package ss17_binari_file_and_serialization.bai_tap.bai_2.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class WriteFile {
    public static void writeFile(String path, List<Object> objectList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Tệp tin đích đã tồn tại. Bạn có muốn ghi đè");
            System.out.println("1. Có");
            System.out.println("2. Không");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(objectList);
                for (Object list : objectList) {
                    System.out.println(list);
                }
                System.out.println("Số byte trong tệp là: " + fileOutputStream.getChannel().size() + " byte");
                objectOutputStream.close();
            }
        }else {
            System.out.println("Hệ thống sẽ tự động tạo file mới");
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectList);
            for (Object list : objectList) {
                System.out.println(list);
            }
            System.out.println("Số byte trong tệp là: " + fileOutputStream.getChannel().size() + " byte");
            objectOutputStream.close();
        }

    }
}
