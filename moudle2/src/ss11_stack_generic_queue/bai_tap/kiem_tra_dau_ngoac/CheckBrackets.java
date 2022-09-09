package ss11_stack_generic_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class CheckBrackets {
    public static void main(String[] args) {
        System.out.println(check());
    }

    public static boolean check() {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> characterStack = new Stack<>();
        System.out.println("Nhập vào chuỗi chứa dâu ngoặc");
        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                characterStack.push(string.charAt(i));
            }
            if (string.charAt(i) == ')') {
                if (characterStack.isEmpty()) {
                    return false;
                } else {
                    characterStack.pop();
                }
            }
        }
        return characterStack.isEmpty();
    }
}
