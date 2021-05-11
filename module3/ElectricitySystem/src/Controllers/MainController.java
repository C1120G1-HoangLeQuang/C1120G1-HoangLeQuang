package Controllers;

import Commons.*;
import Models.*;
import Services.BillManager;
import Services.CustomerManager;
import Services.TypeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final int CUSTOMER_VIETNAMESE = 1;
    private static final int CUSTOMER_FOREIGNER = 2;
    Scanner scanner = new Scanner(System.in);
    CustomerManager customerManager = new CustomerManager();
    BillManager billManager = new BillManager();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

    public void displayMainMenu() {
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
                            showCustomer();
                            break;
                        case 3:
                            searchCustomer();
                            break;
                        case 4:
                            addNewBill();
                            break;
                        case 5:
                            editBill();
                            break;
                        case 6:
                            showBillInfo();
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
    public void addCustomer() {
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
                            addVietnameseCustomer();
                            break;
                        case 2:
                            addForeignCustomer();
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
    public void addVietnameseCustomer() {
        List<String> list = new ArrayList<>();
        TypeManager typeManager = new TypeManager();
        List<CustomerType> typeCustomerList = ReadAndWriteType.readType();
        String customerId;
        do {
            System.out.print("Enter id: ");
            customerId = scanner.nextLine();
        } while (!IdVietnameseRegex.idVietnamese(customerId));
        list.add(customerId);

        String customerName;
        do {
            System.out.print("Enter customer name: ");
            customerName = scanner.nextLine();
        } while (!NameCustomerRegex.nameCustomer(customerName));
        list.add(customerName);

        typeManager.showTypeCustomer();
        int idType = Integer.parseInt(scanner.nextLine());
        String typeCustomer = typeCustomerList.get(idType - 1).getNameType();
        list.add(typeCustomer);

        int limitedUsing = 0;
        try {
            System.out.println("Enter limited using: ");
            limitedUsing = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to be enter integer number");
        }
        list.add(limitedUsing + "");
        String[] vietnameseInfor = list.toArray(new String[0]);
        Vietnamese vietnamese = new Vietnamese(vietnameseInfor);
        customerManager.add(vietnamese);
    }
    public void addForeignCustomer() {
        List<String> list = new ArrayList<>();
        String customerId;
        do {
            System.out.print("Enter id: ");
            customerId = scanner.nextLine();
        } while (!IdForeignRegex.idForeign(customerId));
        list.add(customerId);

        String customerName;
        do {
            System.out.print("Enter customer name: ");
            customerName = scanner.nextLine();
        } while (!NameCustomerRegex.nameCustomer(customerName));
        list.add(customerName);

        System.out.print("Enter nationality: ");
        String nationality = scanner.nextLine();
        list.add(nationality);
        String[] foreignerInfor = list.toArray(new String[0]);
        Foreigner foreigner = new Foreigner(foreignerInfor);
        customerManager.add(foreigner);
    }
    public void showCustomer() {
        System.out.println("---Customer List---");
        customerManager.showCustomers();
    }
    public void searchCustomer() {
        boolean flag;
        do {
            flag = false;
            System.out.print("\nEnter name customer that you need to find: ");
            String customerName = scanner.nextLine();
            Customer customer;
            if ((customer = customerManager.search(customerName)) != null) {
                customer.showInfo();
            } else {
                System.out.println("Customer is not exist");
                while (true) {
                    System.out.println("Do you to find continuously? (1. YES/ 2. NO)");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        flag = true;
                        break;
                    } else if (choice.equals("2")) {
                        break;
                    }
                }
            }
        } while (flag);
    }
    public int chooseCustomer() {
        System.out.println("DANH SÁCH KHÁCH HÀNG:");
        List<Customer> listCustomer = customerManager.findAllCustomers();
        if (listCustomer.size() == 0) {
            System.out.println("CHƯA CÓ KHÁCH HÀNG TRONG DANH SÁCH");
            return null;
        }
        customerManager.showCustomers();
        int index;
        do {
            System.out.print("CHỌN MỘT KHÁCH HÀNG TRONG DANH SÁCH TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= listCustomer.size()) {
                return listCustomer.get(index - 1);
            } else {
                System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            }
        } while (true);
    }
    public void addNewBill() {
        System.out.println("\n==== THÊM HÓA ĐƠN MỚI ====");
        Customer customer = chooseCustomer();
        if (customer == null) {
            return;
        }

        String billId = billManager.getIncrementBillId();
        String customerId = customer.getCustomerId();

        String invoiceDate;
        do {
            System.out.print("NHẬP NGÀY RA HÓA ĐƠN: ");
            invoiceDate = scanner.nextLine();
        } while (Validation.isEmpty(invoiceDate));

        int consumption;
        while (true) {
            System.out.print("NHẬP SỐ LƯỢNG TIÊU THỤ: ");
            try {
                consumption = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("SỐ LƯỢNG TIÊU THỤ PHẢI LÀ ĐỊNH DẠNG SỐ");
            }
        }

        int price;
        while (true) {
            System.out.print("NHẬP ĐƠN GIÁ: ");
            try {
                price = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ĐƠN GIÁ PHẢI LÀ ĐỊNH DẠNG SỐ");
            }
        }
        Bill bill = new Bill(billId, customerId, invoiceDate, consumption, price);
        int total = billManager.calculateTotal(bill);
        bill.setTotal(total);
        billManager.add(bill);
    }
    public void editBill() {
        System.out.println("\n==== DANH SÁCH HÓA ĐƠN ====");
        billManager.showAllBills();
        List<Bill> list = billManager.findAllBills();
        if (list.size() == 0) {
            System.out.println("CHƯA CÓ HÓA ĐƠN NÀO TRONG DANH SÁCH");
            return;
        }
        int index = 0;
        while (true) {
            System.out.print("CHỌN HÓA ĐƠN MUỐN CHỈNH SỬA TỪ DANH SÁCH HÓA ĐƠN TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= list.size()) {
                index -= 1;
                break;
            } else {
                System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            }
        }
        String newCustomerId;
        while (true) {
            System.out.print("NHẬP MÃ KHÁCH HÀNG MỚI: ");
            newCustomerId = scanner.nextLine();
            if (Validation.validateCustomerId(newCustomerId)) {
                break;
            }
            System.out.println("MÃ KHÁCH HÀNG KHÔNG TỒN TẠI");
            while (true) {
                System.out.println("BẠN CÓ MUỐN THỬ LẠI? (1.CÓ | 2.KHÔNG)");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            }
        }
        Bill newBill = list.get(index);
        newBill.setCustomerId(newCustomerId);
        billManager.edit(newBill, newBill.getBillId());
        System.out.println("CHỈNH SỬA THÀNH CÔNG");
    }

    public void showAllBills() {
        System.out.println("\n==== DANH SÁCH HÓA ĐƠN ====");
        billManager.showAllBills();
        while (true) {
            System.out.println("BẠN CÓ MUỐN XEM CHI TIẾT HÓA ĐƠN? (1.CÓ | 2.KHÔNG)");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                showBillDetail();
                return;
            } else if (choice.equals("2")) {
                return;
            }
        }
    }
    public void showBillDetail() {
        List<Bill> list = billManager.findAllBills();
        int index;
        boolean flag = false;
        while (true) {
            System.out.print("CHỌN MỘT HÓA ĐƠN TỪ DANH SÁCH HÓA ĐƠN TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= list.size()) {
                System.out.println("\n==== CHI TIẾT HÓA ĐƠN ====");
                billManager.showBillDetail(list.get(index - 1));
                return;
            }
            System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            while (true) {
                System.out.println("BẠN CÓ MUỐN THỬ LẠI? (1.CÓ | 2.KHÔNG)");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            }
        }
    }
}
