package ngay_2_vong_lap.bai_tap;

import java.util.Scanner;

public class FirstPrime20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 2;
        int countPrime = 0;
        int input;
        System.out.println("Enter number of prime that you need to find: ");
        input = scanner.nextInt();
        while (countPrime <= input) {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(number + " ");
                countPrime++;
            }
            number++;
        }
    }
}
