package Demo_Quang_Product.controller;

import Demo_Quang_Product.service.ProductManager;

import java.util.Scanner;

public class Controller {
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Enter function\n" +
                    "1. Add\n" +
                    "2. Show list\n" +
                    "3. Edit\n" +
                    "4. Delete\n" +
                    "5. Search\n" +
                    "6. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.showProduct();
                    break;
                case 3:
                    productManager.editProduct();
                    break;
                case 4:
                    productManager.deleteProduct();
                    break;
                case 5:
                    productManager.searchProduct();
                    break;
                case 6:
                    System.exit(6);
                    break;
            }
        }
    }
}
