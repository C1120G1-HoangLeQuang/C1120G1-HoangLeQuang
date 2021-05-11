package Controller;

import Library.ForeignManager;
import Library.InvoiceManager;
import Library.VietnameseManager;
import Model.ForeignCustomer;
import Model.Invoice;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static ForeignManager foreignManager = new ForeignManager();
    static VietnameseManager vietnameseManager = new VietnameseManager();
    static InvoiceManager invoiceManager = new InvoiceManager();
    public static void displayMainMenu() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" -------Welcome to Electricity Management System------\n" +
                            "1. Add New Customer\n" +
                            "2. Show Customer\n" +
                            "3. Search Customer\n" +
                            "4. Add New Invoice\n" +
                            "5. Edit Invoice\n" +
                            "6. Show Invoice\n" +
                            "7. Exit");
                    int choiceMain = Integer.parseInt(scanner.nextLine());
                    switch (choiceMain) {
                        case 1:
                            addCustomer();
                            break;
                        case 2:

                            break;
                        case 3:

                            break;
                        case 4:

                            break;
                        case 5:

                            break;
                        case 6:

                            break;
                        case 7:

                            System.exit(7);
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void addCustomer() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Add Customer---\n" +
                            "1. Add Vietnamese Customer\n" +
                            "2. Add Foreign Customer\n" +
                            "3. Back to Main Menu\n" +
                            "4. Exit");
                    int choiceAddTransport = Integer.parseInt(scanner.nextLine());
                    switch (choiceAddTransport) {
                        case 1:
                            vietnameseManager.addVietnamese();
                            break;
                        case 2:
                            foreignManager.addForeign();
                            break;
                        case 3:
                            displayMainMenu();
                            break;
                        case 4:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
}
