package Demo_Quang_Product.service;

import Demo_Quang_Product.common.ReadAndWrite;
import Demo_Quang_Product.model.Product;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    public void addProduct() {
        List<Product> list = new ArrayList<>();
        System.out.print("Enter id: ");
        String id = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        float price = Float.parseFloat(scanner.nextLine());
        Product product = new Product(id, name, price);
        list.add(product);
        ReadAndWrite.writeProduct(list, true);
    }
    public void showProduct() {
        List<Product> list = ReadAndWrite.readProduct();
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }
    public void editProduct() {
        List<Product> list = ReadAndWrite.readProduct();
        showProduct();
        boolean check = true;
        System.out.println("Enter product that be followed by id");
        int idChoice = Integer.parseInt(scanner.nextLine());
        while (check) {
            System.out.println("Enter information that you need to edit: " +"\n"
                + "1. Name" + "\n"
                + "2. Price" + "\n"
                + "3. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Enter name that need to change: ");
                    String name = scanner.nextLine();
                    list.get(idChoice -1).setName(name);
                    break;
                case 2:
                    System.out.print("Enter price that need to change: ");
                    float price = Float.parseFloat(scanner.nextLine());
                    list.get(idChoice -1).setPrice(price);
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.println("You wrong choice, please enter again");
                    break;
            }
        }
        ReadAndWrite.writeProduct(list, false);
    }
    public void deleteProduct() {
        List<Product> list = ReadAndWrite.readProduct();
        showProduct();
        System.out.print("Enter product that followed by id");
        int idChoice = Integer.parseInt(scanner.nextLine());
        list.remove(idChoice - 1);
        ReadAndWrite.writeProduct(list, false);
    }
    public void searchProduct() {
        List<Product> list = ReadAndWrite.readProduct();
        System.out.print("Enter name of product that you wanna find: ");
        String nameProduct = scanner.nextLine();
        for (Product product : list) {
            if (product.getName().contains(nameProduct)) {
                System.out.println(product);
            }
        }
    }
}
