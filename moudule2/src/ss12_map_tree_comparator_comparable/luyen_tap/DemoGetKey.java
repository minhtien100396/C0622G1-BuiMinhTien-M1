package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.Map;
import java.util.TreeMap;

public class DemoGetKey {
    public static void main(String[] args) {
        Map<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"Hải");
        treeMap.put(2,"Trường");
        treeMap.put(3,"Giang");
        treeMap.put(4,"Tiến");

        for (Map.Entry<Integer, String> entry :
                treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }


    }
}
