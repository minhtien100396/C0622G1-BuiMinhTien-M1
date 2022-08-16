package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoTruyCapKey {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Uy");
        map.put(2, "Huy");
        map.put(3, "Tiến");
//        System.out.println(map);
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            System.out.printf("%s - %s\n", entry.getKey(), entry.getValue());
//        }
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1, "Uy");
        map1.put(2, "Huy");
        map1.put(3, "Tiến");
        Map<String,String> map2 = new HashMap<>();
        Map.Entry<String,String> entry1 = map2.entrySet().iterator().next();
        String key = entry1.getKey();
        String value = entry1.getValue();
        System.out.println(key);
    }
}
