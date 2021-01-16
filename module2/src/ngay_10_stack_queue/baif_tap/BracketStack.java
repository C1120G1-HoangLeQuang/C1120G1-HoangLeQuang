package ngay_10_stack_queue.baif_tap;

import java.util.Scanner;
import java.util.Stack;

public class BracketStack {
    public static boolean checkBracket(String inputString) {
       Stack<Character> stack = new Stack<>();
       char symbol;
       for (int i = 0; i < inputString.length(); i++) {
           symbol = inputString.charAt(i);
           if (symbol == '(') {
               stack.push(symbol);
           }
           if (symbol == '(' && inputString.charAt(i+1) == ')') {
               return false;
           } else if (symbol == ')') {
               if (!stack.isEmpty()) {
                   stack.pop();
               } else {
                   return false;
               }
           }
       }
       if (!stack.isEmpty()) {
           return false;
       }
       return true;
   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String inputString;
        inputString = scanner.nextLine();
        if (checkBracket(inputString)) {
            System.out.println("Well");
        } else {
            System.out.println("NO");
        }
    }
}
