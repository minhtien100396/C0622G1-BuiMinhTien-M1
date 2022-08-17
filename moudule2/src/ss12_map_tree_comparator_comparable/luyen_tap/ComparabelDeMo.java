package ss12_map_tree_comparator_comparable.luyen_tap;

import ss12_map_tree_comparator_comparable.bai_tap.bai_1.model.Produce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparabelDeMo implements Comparable<ComparabelDeMo> {
    @Override
    public int compareTo(ComparabelDeMo o) {
        //So sánh đối tượng hiện tại và đối tượng o trong ngoặc
        if (o.age>this.age) return -1;
        if (o.age<this.age) return 1;
        return 0;
    }
    private int age;
    private String name;

    public ComparabelDeMo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<ComparabelDeMo> list = new ArrayList<>();
        list.add(new ComparabelDeMo(18, "Tiến"));
        list.add(new ComparabelDeMo(15, "Trung"));
        list.add(new ComparabelDeMo(25, "Danh"));
        Comparator<ComparabelDeMo> comparator = new Comparator<ComparabelDeMo>() {
            @Override
            public int compare(ComparabelDeMo o1, ComparabelDeMo o2) {
                if (o1.age>o2.age)return 1;
                if (o1.age<o2.age)return -1;
                return 0;
            }
        };
        list.sort(comparator);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
