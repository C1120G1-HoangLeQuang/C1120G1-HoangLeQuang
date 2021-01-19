package ngay_11_collection_framework.bai_tap.production_linkedlist;

import ngay_11_collection_framework.bai_tap.production_arrayedlist.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManagerLinked {
    private int size;
    private static final int CAPACITY = 10;

    LinkedList<ProductLinked> listProduct1;
    Scanner scanner = new Scanner(System.in);

    public ProductManagerLinked() {
        listProduct1 = new LinkedList<ProductLinked>();
    }

    public ProductManagerLinked(int size) {
        this.size = size;
        listProduct1 = new LinkedList<ProductLinked>();
    }

    public void addProduct(ProductLinked product1) {
        listProduct1.addFirst(product1);
    }
    public boolean isExistId(int id1) {
        for (ProductLinked product: listProduct1) {
            if (id1 == product.getId()) {
                return true;
            }
        }
        return false;
    }
    public void editProduct(int id1) {
        for (ProductLinked product1 : listProduct1) {
            if (id1 == product1.getId()) {
                int input;
                System.out.println("Please choose thing that you want to change: " + "\n"
                        + "1. Name" + "\n"
                        + "2. Price");
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        String newName;
                        System.out.print("New name is: ");
                        newName = scanner.nextLine();
                        product1.setName(newName);
                        break;
                    case 2:
                        int newPrice;
                        System.out.print("New price is: ");
                        newPrice = Integer.parseInt(scanner.nextLine());
                        product1.setPrice(newPrice);
                        break;
                }
            }
        }
    }
    public void deleteProduct(int id6) {
        for (ProductLinked product1 : listProduct1) {
            if (id6 == product1.getId()) {
                listProduct1.remove(product1);
                break;
            }
        }
    }
    public void findProduct(String name) {
        boolean check = true;
        for (ProductLinked product1: listProduct1) {
            if (product1.getName().contains(name)) {
                System.out.println("Product is existed in the list " + product1);
                check = false;
            }
        }
        if (check) {
            System.out.println("Not found");
        }
    }
    public void disPlay() {
        ProductLinked product1 = new ProductLinked();
        Collections.sort(listProduct1, product1);
        for (ProductLinked product2: listProduct1) {
            System.out.println(product2);
        }
    }
}
