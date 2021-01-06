package ngay_3_array.bai_tap;

import java.util.Scanner;

public class MinArray {
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] prime;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.print("Size is over 20. Please enter again:");
            }
        } while (size > 20);
        prime = new int[size];
        int i = 0;
        while (i < prime.length) {
            System.out.print("Element of Prime " + i + " : " + " ");
            prime[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Prime: ");
        for (int j = 0; j < prime.length; j++) {
            System.out.print(prime[j] + " ");
        }
        System.out.println();
        System.out.println("The smallest in Prime is: " + findMin(prime));
    }
}
