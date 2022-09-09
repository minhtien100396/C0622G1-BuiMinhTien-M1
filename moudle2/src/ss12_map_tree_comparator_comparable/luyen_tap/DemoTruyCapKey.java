package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.*;

public class DemoTruyCapKey {
    public static void main(String[] args) {
        Map<User, String> map = new TreeMap<>();
//            @Override
//            public int compare(User o1, User o2) {
//                if (o1.id > o2.id) return 1;
//                if (o1.id < o2.id) return -1;
//                return 0;
//            }
//        });
        map.put(new User(5, "Tiến"), "Học Sinh");
        map.put(new User(2, "Bia"), "Giáo viên");
        map.put(new User(3, "Huy"), "Bảo vệ");
        Map<User,String> map1 = new TreeMap<>(map);
        map1.put(new User(43, "Sáng"), "Bảo vệ");
        map1.putAll(map);
        for (User item : map1.keySet()) {
            System.out.printf("%s - %s\n", item, map1.get(item));
        }
    }
}
