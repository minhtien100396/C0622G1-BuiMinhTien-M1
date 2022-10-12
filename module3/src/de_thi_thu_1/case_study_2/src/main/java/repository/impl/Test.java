package repository.impl;

import repository.IPhongTroRepository;

public class Test {
    public static void main(String[] args) {
        IPhongTroRepository repo = new PhongTroRepository();
        System.out.println("Size : "+ repo.selectAllPhongTro().size());
    }
}
