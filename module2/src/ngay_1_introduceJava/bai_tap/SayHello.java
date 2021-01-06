package ngay_1_introduceJava.bai_tap;

import java.util.Scanner;

public class SayHello {
    public static void main(String[] args) {
        System.out.println("Enter the name that you need to say Hello: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello: " + name);
    }
}
