package demoTReeSet;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        A a = new A("a", 20, "Huy");
        A b = new A("a", 20, "Huy");
        Set<A> aList = new TreeSet<>();
        aList.add(a);
        aList.add(b);
        System.out.println(aList);
    }
}
