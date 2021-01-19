package ngay_11_collection_framework.bai_tap.production_arrayedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProductManager{        // thêm, sửa, xoá, hiển thị, tìm kiếm, sắp xếp.
    private int size;
    private static final int CAPACITY = 10;

    ArrayList<Product> listProduct;
    Scanner scanner = new Scanner(System.in);

   public ProductManager() {
        listProduct = new ArrayList<>(CAPACITY);
   }

    public ProductManager(int size) {
        this.size = size;
        listProduct = new ArrayList<>(size);
    }

    public void addProduct(Product product) {
        listProduct.add(product);
   }
   public boolean isExistId(int id) {
       for (Product product: listProduct) {
           if (id == product.getId()) {
               return true;
           }
       }
       return false;
   }
    public void editProduct(int id) {
        for (Product product : listProduct) {
            if (id == product.getId()) {
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
                        product.setName(newName);
                        break;
                    case 2:
                        int newPrice;
                        System.out.print("New price is: ");
                        newPrice = Integer.parseInt(scanner.nextLine());
                        product.setPrice(newPrice);
                        break;
                }
            }
        }
    }
    public void deleteProduct(int id) {
        for (Product product : listProduct) {
            if (id == product.getId()) {
                listProduct.remove(product);
                break;
            }
        }
    }
    public void findProduct(String name) {
       boolean check = true;
        for (Product product: listProduct) {
            if (product.getName().contains(name)) {
                System.out.println("Product is existed in the list " + product);
                check = false;
            }
        }
        if (check) {
            System.out.println("Not found");
        }
    }
    public void disPlay() {
//       Product product = new Product();
//        Collections.sort(listProduct, product);
       for (Product product1: listProduct) {
            System.out.println(product1);
        }
    }
    public void priceUp() {
        PriceComparatorUp priceComparatorUp = new PriceComparatorUp();
        Collections.sort(listProduct, priceComparatorUp);
        disPlay();
    }
    public void priceDown() {
       PriceComparatorDown priceComparatorDown = new PriceComparatorDown();
       Collections.sort(listProduct, priceComparatorDown);
       disPlay();
    }
}
