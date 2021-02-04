package Libs;

import Commons.ReadAndWriteCustomer;
import Models.Customer;
import Regex.CustomerRegex.*;

import java.util.*;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    public void addCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
        StandardData standardData = new StandardData();
        String nameCustomer;
        do {
            System.out.print("Enter name customer: ");
            nameCustomer = scanner.nextLine();
        } while (!NameCustomerRegex.checkNameCustomer(nameCustomer));
        String dateOfBirth;
        do {
            System.out.print("Enter date of birth: ");
            dateOfBirth = scanner.nextLine();
        } while (!DOBRegex.checkDOB(dateOfBirth));
        String gender;
        do {
            System.out.print("Enter gender: ");
            gender = scanner.nextLine();
        } while (!GenderRegex.checkGender(gender));
        gender = standardData.standardized(gender);
        int idCustomer = 0;
        do {
            try {
                System.out.print("Enter id customer: ");
                idCustomer = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Id have to be integer number");
            }
        } while (!IdCustomerRegex.checkIdCustomer(idCustomer));
        int phoneNumber = 0;
        try {
            System.out.print("Enter phone number: ");
            phoneNumber = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException e) {
            System.out.println("Telephone number have to be integer number");
        }
        String email = "";
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
        } while (!EmailRegex.checkEmail(email));
        System.out.print("Enter type of customer: ");
        String typeCustomer = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(nameCustomer, dateOfBirth, gender, idCustomer, phoneNumber, email, typeCustomer, address);
        listCustomer.add(customer);
        ReadAndWriteCustomer.writeCustomer(listCustomer, true);
    }
    public void showCustomer() {
        List<Customer> listCustomer = ReadAndWriteCustomer.readCustomer();
        NameComparatorUp nameComparatorUp = new NameComparatorUp();
        Collections.sort(listCustomer, nameComparatorUp);
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println((i+1) + ". " + listCustomer.get(i).showInformation());
        }
    }
}
