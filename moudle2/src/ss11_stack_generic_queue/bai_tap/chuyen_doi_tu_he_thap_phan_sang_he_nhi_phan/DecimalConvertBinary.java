package ss11_stack_generic_queue.bai_tap.chuyen_doi_tu_he_thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class DecimalConvertBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> integerStack = new Stack<>();
        System.out.println("Nhập vào số muốn chuyển đổi");
        int number = Integer.parseInt(scanner.nextLine());
        while (number != 0) {
            integerStack.push(number % 2);
            number /= 2;
        }
        while (!integerStack.isEmpty()) {
            System.out.print(integerStack.pop());
        }
    }
}
