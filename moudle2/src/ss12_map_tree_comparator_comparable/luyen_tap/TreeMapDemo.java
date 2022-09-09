package ss12_map_tree_comparator_comparable.luyen_tap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
    /*
    KeyMap không chứa key null
    key được sắp xếp mặc định là tăng dần
     */
    public static void main(String[] args) {
        Map<Integer,String> treeMap = new TreeMap<>();
        //put():Thêm phần tử vào map
        treeMap.put(1,"Một");
        treeMap.put(3,"Ba");
        treeMap.put(2,"Hai");
        //Duyệt mảng bằng forEach
//        for (Integer key:treeMap.keySet()) {
//            System.out.println(treeMap.get(key));
//        }
        //Duyệt mảng bằng EntryMap
//        for (Map.Entry<Integer,String> entry:treeMap.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());
//        }
        //get():Truy cập các phần tử
        //put():Cập nhật lại giá trị của Key
        treeMap.put(2,"Giá trị mới");
        System.out.println(treeMap.get(2));
        treeMap.remove(2);
        for (Map.Entry<Integer,String> entry:treeMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }


    }


}
