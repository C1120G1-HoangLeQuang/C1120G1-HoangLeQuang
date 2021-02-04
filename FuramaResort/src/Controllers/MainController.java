package Controllers;

import Commons.ReadAndWriteCustomer;
import Libs.*;
import Models.Customer;

import java.util.*;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static VillaManager villaManager = new VillaManager();
    static HouseManager houseManager = new HouseManager();
    static RoomManager roomManager = new RoomManager();
    static CustomerManager customerManager = new CustomerManager();
    static BookingManager bookingManager = new BookingManager();
    static EmployeeManager employeeManager = new EmployeeManager();
    static Queue<String> cinemaQueue = new LinkedList<>();
    public static void disPlayMainMenu() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" -------Welcome to Furama Resort------\n" +
                            "1. Add New Service\n" +
                            "2. Show Service\n" +
                            "3. Add New Customer\n" +
                            "4. Show Information Customer\n" +
                            "5. Add New Booking\n" +
                            "6. Add Information of Employee\n" +
                            "7. Show Information of Employee\n" +
                            "8. Find Information of Employee\n" +
                            "9. Show Cinema Service\n" +
                            "10. Exit");
                    int choiceMain = Integer.parseInt(scanner.nextLine());
                    switch (choiceMain) {
                        case 1:
                            addNewService();
                            break;
                        case 2:
                            showService();
                            break;
                        case 3:
                            addNewCustomer();
                            break;
                        case 4:
                            showInformationCustomer();
                            break;
                        case 5:
                            addNewBooking();
                            break;
                        case 6:
                            addInformationEmployee();
                            break;
                        case 7:
                            showInformationEmployee();
                            break;
                        case 8:
                            findCabinetEmployee();
                            break;
                        case 9:
                            showCinemaService();
                            break;
                        case 10:
                            System.exit(10);
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void addNewService() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Add Service---\n" +
                            "1. Add New Villa\n" +
                            "2. Add New House\n" +
                            "3. Add New Room\n" +
                            "4. Back to Main Menu\n" +
                            "5. Exit");
                    int choiceAddService = Integer.parseInt(scanner.nextLine());
                    switch (choiceAddService) {
                        case 1:
                            villaManager.addVilla();
                            break;
                        case 2:
                            houseManager.addHouse();
                            break;
                        case 3:
                            roomManager.addRoom();
                            break;
                        case 4:
                            disPlayMainMenu();
                            break;
                        case 5:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void showService() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Show Service---\n" +
                            "1. Show all Villa\n" +
                            "2. Show all House\n" +
                            "3. Show all Room\n" +
                            "4. Show All Name Villa Not Duplicate\n" +
                            "5. Show All Name House Not Duplicate\n" +
                            "6. Show All Name Room Not Duplicate\n" +
                            "7. Back to Main Menu\n" +
                            "8. Exit");
                    int choiceShowService = Integer.parseInt(scanner.nextLine());
                    switch (choiceShowService) {
                        case 1:
                            villaManager.showVilla();
                            break;
                        case 2:
                            houseManager.showHouse();
                            break;
                        case 3:
                            roomManager.showRoom();
                            break;
                        case 4:
                            villaManager.showVillaNotDuplicate();
                            break;
                        case 5:
                            houseManager.showHouseNotDuplicate();
                            break;
                        case 6:
                            roomManager.showRoomNotDuplicate();
                            break;
                        case 7:
                            disPlayMainMenu();
                            break;
                        case 8:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void addNewCustomer () {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Add Customer---\n" +
                            "1. Add New Customer\n" +
                            "2. Back to Main Menu\n" +
                            "3. Exit");
                    int choiceAddCustomer = Integer.parseInt(scanner.nextLine());
                    switch (choiceAddCustomer) {
                        case 1:
                            customerManager.addCustomer();
                            break;
                        case 2:
                            disPlayMainMenu();
                            break;
                        case 3:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void showInformationCustomer() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Show Customer---\n" +
                            "1. Show information Customer\n" +
                            "2. Back to Main Menu\n" +
                            "3. Exit");
                    int choiceShowCustomer = Integer.parseInt(scanner.nextLine());
                    switch (choiceShowCustomer) {
                        case 1:
                            customerManager.showCustomer();
                            break;
                        case 2:
                            disPlayMainMenu();
                            break;
                        case 3:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void addNewBooking() {
        bookingManager.addBooking();
        bookingManager.showBooking();
    }
    public static void addInformationEmployee() {
       employeeManager.addEmployee();
    }
    public static void showInformationEmployee() {
        employeeManager.showEmployee();
    }
    public static void showCinemaService() {
        int numTicket = 3;
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Enter function Show Cinema Service---\n" +
                            "1. Add Cinema Customer \n" +
                            "2. Show Cinema Customer \n" +
                            "3. Back to Main Menu\n" +
                            "4. Exit");
                    int choiceCinemaCustomer = Integer.parseInt(scanner.nextLine());
                    switch (choiceCinemaCustomer) {
                        case 1:
                            List<Customer> listCinema = ReadAndWriteCustomer.readCustomer();
                            if (cinemaQueue.size() < numTicket) {
                                for (int i = 0; i < listCinema.size(); i++) {
                                    System.out.println((i+1) + ". " + listCinema.get(i).showInformation());
                                }
                                System.out.println("Please choose customer to buy ticket!");
                                int choiceCustomerBuy = Integer.parseInt(scanner.nextLine());
                                cinemaQueue.offer(listCinema.get(choiceCustomerBuy -1).getNameCustomer());
                            } else {
                                System.out.println("Out of ticket");
                            }
                            break;
                        case 2:
                            if (cinemaQueue.size() == numTicket) {
//                        System.out.println("The rest of ticket: " + (numTicket - cinemaQueue.size()));
                                while (!cinemaQueue.isEmpty()) {
                                    System.out.println(cinemaQueue.poll());
                                }
                            } else {
                                System.out.println("The rest of ticket: " + (numTicket - cinemaQueue.size()));
                            }
                            break;
                        case 3:
                            disPlayMainMenu();
                            break;
                        case 4:
                            System.exit(choiceCinemaCustomer);
                            break;
                        default:
                            System.out.println("Error");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void findCabinetEmployee() {
        while (true) {
            try {
                System.out.println("Enter id of employee: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println(employeeManager.findEmployee(id));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id have to be integer number");
            }
        }
    }
}
