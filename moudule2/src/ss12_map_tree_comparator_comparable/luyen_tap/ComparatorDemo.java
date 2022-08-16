package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {
    private int age;
    private String name;

    public ComparatorDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<ComparatorDemo> list = new ArrayList<>();
        list.add(new ComparatorDemo(18, "Tiến"));
        list.add(new ComparatorDemo(15, "Trung"));
        list.add(new ComparatorDemo(25, "Danh"));
        Comparator<ComparatorDemo> nhanVienComparator = new Comparator<ComparatorDemo>() {
            @Override
            public int compare(ComparatorDemo o1, ComparatorDemo o2) {
                if (o1.age > o2.age)
                    return 1;
                if (o1.age < o2.age)
                    return -1;

                return 0;
            }
        };
        list.sort(nhanVienComparator);
        System.out.println(list);
    }
}

