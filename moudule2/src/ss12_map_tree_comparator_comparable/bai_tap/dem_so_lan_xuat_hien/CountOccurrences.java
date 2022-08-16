package ss12_map_tree_comparator_comparable.bai_tap.dem_so_lan_xuat_hien;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi muốn kiểm tra");
        String newString = scanner.nextLine();
        String str = newString.toLowerCase().replace(" ", "");
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                Integer value = map.get(str.charAt(i));
                value++;
                map.replace(str.charAt(i), value);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
