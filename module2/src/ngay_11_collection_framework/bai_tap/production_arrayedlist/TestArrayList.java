package ngay_11_collection_framework.bai_tap.production_arrayedlist;

import java.util.Scanner;

public class TestArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManager manager = new ProductManager();
        Product product1 = new Product(1, "Toshiba", 500.5);
        Product product2 = new Product(2, "Panasonic", 400.6);
        Product product3 = new Product(3, "Iphone", 700.8);
        Product product4 = new Product(4, "SamSung", 300.3);
        Product product5 = new Product(5, "Nokia", 200.9);
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);

        int choice = -1;
        while (choice!=0) {
            System.out.println("Enter the method that you using! " + "\n"
                    + "1. AddProduct" + "\n"
                    + "2. EditProduct" + "\n"
                    + "3. DeleteProduct" + "\n"
                    + "4. FindProduct" + "\n"
                    + "5. DisplayProduct" + "\n"
                    + "6. Arrangement" + "\n"
                    + "7. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 :
                    System.out.println("How many items that you wanna addition? ");
                    int number = Integer.parseInt(scanner.nextLine());
                    int id;
                    for (int i = 0; i < number; i++) {
                        Product product = new Product();
                        do {
                            System.out.print("Enter id: ");
                            id = Integer.parseInt(scanner.nextLine());
                            if (manager.isExistId(id)) {
                                System.out.println("Error id, enter again!");
                            }
                        } while (manager.isExistId(id));
                            product.setId(id);
                        System.out.print("Enter name: ");
                        String name = scanner.nextLine();
                        product.setName(name);
                        System.out.print("Enter price: ");
                        int price = Integer.parseInt(scanner.nextLine());
                        product.setPrice(price);
                        manager.addProduct(product);
                    }
                    break;
                case 2 :
                    System.out.println("Enter id that you wanna change: ");
                    int id2 = Integer.parseInt(scanner.nextLine());
                    manager.editProduct(id2);
                    break;
                case 3 :
                    System.out.println("Enter id that you wanna delete: ");
                    int id1 = Integer.parseInt(scanner.nextLine());
                    manager.deleteProduct(id1);
                    break;
                case 4 :
                    System.out.println("Enter name that you wanna find: ");
                    String name = scanner.nextLine();
                    manager.findProduct(name);
                    break;
                case 5 :
                    manager.disPlay();
                    break;
                case 6 :
                    while (choice != 0) {
                        System.out.println("Would you like to choose Ascending or Descending?" + "\n"
                        + "1. Ascending" + "\n"
                        + "2. Descending" + "\n");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1 :
                                manager.priceUp();
                                break;
                            case 2 :
                                manager.priceDown();
                                break;
                        }
                        break;
                    }
                    break;
                case 7 :
                    System.exit(7);
                    break;
            }
        }
    }
}
