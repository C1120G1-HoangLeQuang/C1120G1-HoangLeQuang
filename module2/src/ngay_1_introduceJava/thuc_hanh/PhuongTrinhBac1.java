package ngay_1_introduceJava.thuc_hanh;

import java.util.Scanner;

public class PhuongTrinhBac1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a, b, c;
        System.out.println("Enter a: ");
        a = scanner.nextDouble();
        System.out.println("Enter b: ");
        b = scanner.nextDouble();
        System.out.println("Enter c: ");
        c = scanner.nextDouble();
        if (a != 0) {
            double result = (c - b) / a;
            System.out.println("Only one solution: " + result);
        } else {
            if (b == 0) {
                System.out.println("The solution is all x");
            } else {
                System.out.println("No solution");
            }
        }
    }
}
