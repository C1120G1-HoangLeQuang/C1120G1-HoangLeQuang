package ngay_2_vong_lap.bai_tap;

import java.util.Scanner;

public class DisplayHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Enter your choice: ");
        choice = scanner.nextInt();
        System.out.println("Menu");
        System.out.println("1. Draw the rectangle");
        System.out.println("2. Draw the square triangle (bottom-left)");
        System.out.println("3. Draw the square triangle (top-left)");
        System.out.println("4. Draw the isosceles triangle");
        System.out.println("5. Exit");
        switch (choice) {
            case 1 :
                System.out.println("Draw the rectangle: ");
                int h = 7;
                int w = 3;
                for (int i = 0; i < w; i++){
                    for (int j = 0; j < h; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 2 :
                System.out.println("Draw the square triangle (bottom-left): ");
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 3 :
                System.out.println("Draw the square triangle (top-left): ");
                for (int i = 0; i < 7; i++) {
                    for (int j = 7; j > i; j--) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 4 :
                System.out.println("Draw the isosceles triangle: ");
                int c = 5;
                int x, output;
                for (int i = 0; i < c; i++) {
                    for (int j = 0; j < 2*c; j++) {
                        x = j - c;
                        if (x < 0) {
                            x *= -1;
                        }
                        output = i - x;
                        if (output > 0) {
                            System.out.printf("%3d",output);
                        } else {
                            System.out.printf("   ");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }
}
