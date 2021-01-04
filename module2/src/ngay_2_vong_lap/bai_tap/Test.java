package ngay_2_vong_lap.bai_tap;

import java.util.Scanner;

public class Test {
    boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        } else {
            for (int i = 2; i<= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    void inputPrime(int n) {
        for (int i = 1; i < n; i++) {
            if (checkPrime(i)) {
                System.out.print(" " + i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Test output = new Test();
        int n;
        System.out.println("Enter n: ");
        n = scanner.nextInt();
        output.inputPrime(n);
    }
}
