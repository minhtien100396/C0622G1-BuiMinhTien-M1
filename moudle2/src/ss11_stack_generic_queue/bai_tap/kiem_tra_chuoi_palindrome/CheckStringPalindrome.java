package ss11_stack_generic_queue.bai_tap.kiem_tra_chuoi_palindrome;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckStringPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi cần kiểm tra");
        String strings = scanner.nextLine();
        String newString = strings.toLowerCase();
        Stack<Character> stringStack = new Stack<>();
        Queue<Character> stringQueue = new LinkedList<>();
        for (int i = 0; i < newString.length(); i++) {
            stringQueue.add(newString.charAt(i));
            stringStack.add(newString.charAt(i));
        }
        while (!stringQueue.isEmpty() && !stringStack.isEmpty()) {
            if (!(stringQueue.remove().equals(stringStack.pop()))) {
                System.out.println("Không phải chuỗi Palindrome");
                return;
            }
        }
        System.out.println("Là chuỗi Palindrome");
    }
}
