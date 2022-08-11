package ss9_array_list_linked_list.luyen_tap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        array.add("Tiến");
        array.add(new User("Tan").toString());
        array.add("1,new User()");
        array.add(1);
//        System.out.println(array);
//        Integer a = new Integer(1);
//        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//        System.out.println(arrayList);
//        System.out.println(arrayList.get(1));
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        };
    }
}
