package ngay_2_vong_lap.bai_tap;

import java.util.Scanner;

public class PrimeFirstNhoHon100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int num = 0;
        String  primeNumbers = "";
        System.out.println("Enter n:");
        int n = scanner.nextInt();
        for (i = 1; i < n; i++) {
            int counter = 0;
            for(num = i; num >= 1; num--) {
                if(i % num==0) {
                    counter++;
                }
            }
            if (counter ==2) {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Number of prime less than " + n + " is: ");
        System.out.println(primeNumbers);
    }
}

