package ss11_stack_generic_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử cho mảng");
        int number = Integer.parseInt(scanner.nextLine());
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Nhập vào giá trị của phần tử thứ " + i);
            array[i] = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("Mảng ban đầu: " + Arrays.toString(array));
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println("Mảng đảo ngược: " + Arrays.toString(array));
    }
}
