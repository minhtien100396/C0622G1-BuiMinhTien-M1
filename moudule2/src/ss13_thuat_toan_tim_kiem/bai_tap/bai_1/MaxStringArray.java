package ss13_thuat_toan_tim_kiem.bai_tap.bai_1;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxStringArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi bất kì");
        String randomString = scanner.nextLine();
        System.out.println("Chuỗi tăng dần có độ dài lớn nhất là: ");
        findMaxArray(randomString);
    }
    public static void findMaxArray(String str) {
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character linkedList : max ) {
            System.out.print(linkedList);
        }
    }
}
