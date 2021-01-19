package ngay_11_collection_framework.bai_tap.production_linkedlist;

import ngay_11_collection_framework.bai_tap.production_arrayedlist.Product;
import ngay_11_collection_framework.bai_tap.production_arrayedlist.ProductManager;

import java.util.Scanner;

public class TestLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagerLinked managerLinked = new ProductManagerLinked();
        ProductLinked product1 = new ProductLinked(1, "Toshiba", 500.5);
        ProductLinked product2 = new ProductLinked(2, "Panasonic", 400.6);
        ProductLinked product3 = new ProductLinked(3, "Iphone", 700.8);
        ProductLinked product4 = new ProductLinked(4, "SamSung", 300.3);
        ProductLinked product5 = new ProductLinked(5, "Nokia", 200.9);
        managerLinked.addProduct(product1);
        managerLinked.addProduct(product2);
        managerLinked.addProduct(product3);
        managerLinked.addProduct(product4);
        managerLinked.addProduct(product5);

        int choice = -1;
        while (choice!=0) {
            System.out.println("Enter the method that you using! " + "\n"
                    + "1. AddProduct" + "\n"
                    + "2. EditProduct" + "\n"
                    + "3. DeleteProduct" + "\n"
                    + "4. FindProduct" + "\n"
                    + "5. DisplayProduct" + "\n"
                    + "6 Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 :
                    System.out.println("How many items that you wanna addition? ");
                    int number = Integer.parseInt(scanner.nextLine());
                    int id;
                    for (int i = 0; i < number; i++) {
                        ProductLinked product = new ProductLinked();
                        do {
                            System.out.print("Enter id: ");
                            id = Integer.parseInt(scanner.nextLine());
                            if (managerLinked.isExistId(id)) {
                                System.out.println("Error id, enter again!");
                            }
                        } while (managerLinked.isExistId(id));
                        product.setId(id);
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        product.setName(name);
                        System.out.print("Enter price: ");
                        int price = Integer.parseInt(scanner.nextLine());
                        product.setPrice(price);
                        managerLinked.addProduct(product);
                    }
                    break;
                case 2 :
                    System.out.println("Enter id that you wanna change: ");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    managerLinked.editProduct(id2);
                    break;
                case 3 :
                    System.out.println("Enter id that you wanna delete: ");
                    int id7 = Integer.parseInt(scanner.nextLine());
                    managerLinked.deleteProduct(id7);
                    break;
                case 4 :
                    System.out.println("Enter name that you wanna find: ");
                    String name = scanner.nextLine();
                    managerLinked.findProduct(name);
                    break;
                case 5 :
                    managerLinked.disPlay();
                    break;
                case 6:
                    System.exit(6);
                    break;
            }
        }
    }
}
