package Controllers;

import java.util.Scanner;

public class MainController {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Enter function\n" +
                    "1. Add New Service\n" +
                    "2. Show Service\n" +
                    "3. Add New Customer\n" +
                    "4. Show Information Customer\n" +
                    "5. Add New Booking\n" +
                    "6. Show Information of Employee\n" +
                    "7. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
        }
    }
}
