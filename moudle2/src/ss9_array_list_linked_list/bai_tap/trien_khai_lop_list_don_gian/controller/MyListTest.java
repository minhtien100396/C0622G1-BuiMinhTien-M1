package ss9_array_list_linked_list.bai_tap.trien_khai_lop_list_don_gian.controller;

import ss9_array_list_linked_list.bai_tap.trien_khai_lop_list_don_gian.model.MyList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("Phần tử thứ 4: " + listInteger.get(4));
        System.out.println("Phần tử thứ 2: " + listInteger.get(2));
        System.out.println("Phần tử thứ 1: " + listInteger.get(1));
        //System.out.println("Phần tử thứ 6: "+listInteger.get(6));
        listInteger.get(-1);
        System.out.println("Phần tử ở vị trí -1: " + listInteger.get(-1));


    }
}
