package ngay_10_stack_queue.baif_tap;

import java.util.Scanner;
import java.util.Stack;

public class TransferIntoBinary{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        System.out.println("Enter number that need to transfer: ");
        int number;
        int surplus;
        number = scanner.nextInt();
        do {
            surplus =  number % 2;
            stack.push(surplus);
            number = number / 2;
        } while (number != 0);
        System.out.println(stack); // vi stack la mot mang? nen phai duyet while de in ra chuoi
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
