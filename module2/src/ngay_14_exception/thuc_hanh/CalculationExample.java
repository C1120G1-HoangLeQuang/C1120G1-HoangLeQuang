package ngay_14_exception.thuc_hanh;

import java.util.Scanner;

public class CalculationExample {
    private void calculate(int x, int y) {
        try {
            int a = x + y;
            int b = x - y;
            int c = x * y;
            int d = x / y;
            System.out.println("Tong: " + a);
            System.out.println("Hieu: " + b);
            System.out.println("Nhan: " + c);
            System.out.println("Chia: " + d);
        } catch (Exception e) {
            System.out.println("Exist the exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        CalculationExample calculationExample = new CalculationExample();
        calculationExample.calculate(x, y);
    }
}
