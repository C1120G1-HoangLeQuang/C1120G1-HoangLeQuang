package ngay_10_stack_queue.baif_tap;

import java.util.Scanner;
import java.util.Stack;

public class ReverseArrayByStack {
    public static void reversePrimeArray(int[] arrayPrime) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("Pre - array: ");
        for (int i = 0; i < arrayPrime.length; i++) {
            System.out.print(arrayPrime[i] + " ");
            stack.push(arrayPrime[i]);
        }
        System.out.println();
        System.out.println("After - array: ");
        if (!stack.isEmpty()) {
            for (int i = 0; i < arrayPrime.length; i++) {
                arrayPrime[i] = stack.pop();
                System.out.print(arrayPrime[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arrayPrime = {5, 4, 3, 2, 1};
        reversePrimeArray(arrayPrime);
    }
}
