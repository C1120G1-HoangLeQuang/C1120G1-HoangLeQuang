package Libs;

import Commons.ReadAndWriteCustomer;
import Models.Customer;
import Regex.CustomerRegex.*;

import java.util.*;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    public void addCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
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
        int idCustomer;
        do {
            System.out.print("Enter id customer: ");
            idCustomer = Integer.parseInt(scanner.nextLine());
        } while (!IdCustomerRegex.checkIdCustomer(idCustomer));
        int phoneNumber;
        System.out.print("Enter phone number: ");
        phoneNumber = Integer.parseInt(scanner.nextLine());
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
