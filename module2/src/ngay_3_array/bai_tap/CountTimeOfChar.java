package ngay_3_array.bai_tap;

import java.util.Scanner;

public class CountTimeOfChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] prime;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 20) {
                System.out.print("Size is over limit. Enter again");
            }
        }while (size > 20);
        prime = new int[size];
        int i;
        for (i = 0; i < prime.length; i++) {
            System.out.print("Prime element " + i + " : ");
            prime[i] = scanner.nextInt();
        }
        System.out.print("Prime array is: ");
        for (i = 0; i < prime.length; i++) {
            System.out.print(prime[i] + " ");
        }
        System.out.println();
        System.out.print("Enter prime that you want to know how many time is it appear: ");
        int number = scanner.nextInt();
        int count = 0;
        boolean check = false;
        for (i = 0; i < prime.length; i++) {
            if (prime[i] == number) {
                count++;
                check = true;
            }
        }
        if (!check) {
            System.out.print("Number " + number + " don't exist in the Prime array");
        }
        System.out.print("Number " + number + " appear " + count + " time in the Prime array");
    }
}
