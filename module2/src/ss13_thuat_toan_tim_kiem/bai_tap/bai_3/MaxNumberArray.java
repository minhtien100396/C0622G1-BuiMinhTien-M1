package ss13_thuat_toan_tim_kiem.bai_tap.bai_3;

import java.util.LinkedList;
import java.util.Scanner;

public class MaxNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử cho mảng");
        int elementNumber = Integer.parseInt(scanner.nextLine());
        int[] array = new int[elementNumber];
        for (int i = 0; i < elementNumber; i++) {
            System.out.printf("Hãy nhập giá trị cho array[%d] = ", i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Các số tăng dần có độ dài lớn nhất là: ");
        System.out.println(findMaxArray(array));
    }

    public static LinkedList<Integer> findMaxArray(int[] arr) {
        LinkedList<Integer> max = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > list.getLast()) {
                    list.add(arr[j]);
                } else {
                    break;
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        return max;
    }
}
