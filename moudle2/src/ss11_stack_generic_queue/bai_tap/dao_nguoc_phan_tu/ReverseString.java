package ss11_stack_generic_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi bất kì");
        String strings = scanner.nextLine();
        String newString = "";
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < strings.length(); i++) {
            stringStack.push(String.valueOf(strings.charAt(i)));
        }
        for (int i = 0; i < strings.length(); i++) {
            newString += stringStack.pop();
        }
        System.out.println(newString);
    }
}
