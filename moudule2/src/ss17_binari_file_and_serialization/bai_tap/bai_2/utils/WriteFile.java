package ss17_binari_file_and_serialization.bai_tap.bai_2.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFile {
    public static void writeFile(String path, List<Object> objectList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(objectList);
        for (Object list : objectList){
            System.out.println(list);
        }
        System.out.println("Số byte trong tệp là: "+fileOutputStream.getChannel().size()+" byte");
        objectOutputStream.close();
    }
}
