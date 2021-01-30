package Libs;

import Commons.ReadAndWriteCustomer;
import Models.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    Scanner scanner = new Scanner(System.in);
    public void addCustomer() {
        List<Customer> listCustomer = new ArrayList<>();
        String nameCustomer;
        System.out.print("Enter name customer: ");
        nameCustomer = scanner.nextLine();
        String dateOfBirth;
        System.out.print("Enter date of birth: ");
        dateOfBirth = scanner.nextLine();
        String gender;
        System.out.print("Enter gender: ");
        gender = scanner.nextLine();
        int idCustomer;
        System.out.print("Enter id customer: ");
        idCustomer = Integer.parseInt(scanner.nextLine());
        int phoneNumber;
        System.out.print("Enter phone number: ");
        phoneNumber = Integer.parseInt(scanner.nextLine());
        String email;
        System.out.print("Enter email: ");
        email = scanner.nextLine();
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
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println((i+1) + ". " + listCustomer.get(i).showInformation());
        }
    }
}
