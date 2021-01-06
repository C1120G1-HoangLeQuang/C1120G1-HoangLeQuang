package ngay_3_array.thuc_hanh;

import java.util.Scanner;

public class TransferTemperature {
    public static double CtoF(double c) {
        double f = (9.0 / 5) * c + 32;
        return f;
    }
    public static double FtoC(double f) {
        double c = (5.0 / 9) * (f - 32);
        return c;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c;
        double f;
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 :
                    System.out.print("Enter f: ");
                    f = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + FtoC(f));
                    break;
                case  2 :
                    System.out.print("Enter c: ");
                    c = scanner.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + CtoF(c));
                case 3 :
                    System.exit(3);
            }
        } while (choice != 3);
    }
}
