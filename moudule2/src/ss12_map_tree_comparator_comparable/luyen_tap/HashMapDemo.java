package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        /*
        Các class triển khai của Map:
        HashMap
        HashTable
        LinkedHashMap
        TreeMap
         */
        Map<Integer, String> myMap = new HashMap<>();
        Map<Integer,String> myMap2 = new HashMap<>();
        myMap2.put(4,"Bốn");
        myMap2.put(5,"Năm");
        //put(): Thêm phần tử.
        myMap.put(1, "Một");
        myMap.put(2, "Hai");
        myMap.put(3, "Ba");
        //get():Lấy giá trị của key
//        System.out.println(myMap.get(1));
        //Duyệt map bằng forEach
//        for (Integer key:myMap.keySet()) {
//            System.out.println(myMap.get(key));
//        }
        //Duyệt map bằng forIndex
//        for (int i = 1; i <= myMap.size() ; i++) {
//            System.out.println(myMap.get(i));
//        }
        //putAll():Thêm phần tử từ map khác
        myMap.putAll(myMap2);

        //remove():Xóa phần tử khỏi map
        myMap.remove(4);

        //clear():Xóa tất cả phần tử của map
        //myMap.clear();
        for (Integer key:myMap.keySet()) {
            System.out.println(myMap.get(key)+" "+key);
        }
        //size():Kiểm tra kích thước của map
        System.out.println(myMap.size());

        //containsKey():Kiểm tra map có chứa key đã tồn tại hay chưa? Nếu tồn tại trả về true ngược lại false
        System.out.println(myMap.containsKey(1));
        //containsValue():Kiểm tra map có chứa gia trị đã tồn tại hay chưa? Nếu tồn tại trả về true ngược lại false
        System.out.println(myMap.containsValue("Sáu"));
        //put():Cập nhật lại giá trị cho Key
        myMap.put(2,"New");
        System.out.println(myMap.get(2));
    }
}
