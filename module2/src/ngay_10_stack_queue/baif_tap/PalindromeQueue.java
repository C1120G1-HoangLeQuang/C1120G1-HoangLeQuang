package ngay_10_stack_queue.baif_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new LinkedList<>();
        Stack stack = new Stack<>();
        System.out.println("Enter String: ");
        String inputString;
        inputString = scanner.next();
        for (int i = 0; i < inputString.length(); i++) {
            queue.add(inputString.charAt(i));
            stack.push(inputString.charAt(i));
        }
        String reverseString1 = "";
        while (!stack.isEmpty()) {
            reverseString1 = reverseString1 + stack.pop();
        }
        String reverseString2 = "";
        while (!queue.isEmpty()) {
            reverseString2 = reverseString2 + queue.remove();
        }
        if (reverseString1.equals(reverseString2)) {
            System.out.println("This is Palindrome");
        } else {
            System.out.println("This is not Palindrome");
        }

    }
}
