package ss17_binari_file_and_serialization.bai_tap.bai_1.service;

import java.io.IOException;

public interface IProduceService {
    void addProduce() throws IOException, ClassNotFoundException;

    void displayProduce() throws IOException, ClassNotFoundException;

    void searchProduce() throws IOException, ClassNotFoundException;
}
