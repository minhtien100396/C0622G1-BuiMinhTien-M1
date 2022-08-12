package ss10_stack_and_queue.luyen_tap.demo_3.controller;

import java.util.ArrayList;

public class Main {
    public static void hienThi(ArrayList<? super Integer> objects  ) {
        for (Object o : objects) {
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        ArrayList<Double> arrayList1 = new ArrayList<>();
        arrayList1.add(1.1);
        arrayList1.add(1.2);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("Tiến");
        arrayList2.add("Bia");
        hienThi(arrayList);
//        hienThi(arrayList1);
//        hienThi(arrayList2);
    }
}
