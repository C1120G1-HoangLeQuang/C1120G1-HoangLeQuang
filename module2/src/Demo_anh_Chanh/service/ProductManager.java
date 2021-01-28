package Demo_anh_Chanh.service;

import Demo_anh_Chanh.common.FuncWriteAndRead;
import Demo_anh_Chanh.model.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scanner = new Scanner(System.in);
    public void addNewProduct(){
        List<Product> list = new ArrayList<>();
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sp");
        String name = scanner.nextLine();
        System.out.println("Nhập giá");
        float price = Float.parseFloat(scanner.nextLine());
        Product product = new Product(id,name,price);
        list.add(product);
        FuncWriteAndRead.writeProduct(list,true);
    }
    public void showProductList(){
        List<Product> list = FuncWriteAndRead.readProduct();
        for (int i=0; i<list.size(); i++) {
            System.out.println((1+i)+ ". "+ list.get(i));
        }
    }
    public void editProduct(){
        List<Product> list = FuncWriteAndRead.readProduct();
        showProductList();
        boolean flag=true;
        System.out.println("Chọn sản phẩm muốn sửa");
        int choose = Integer.parseInt(scanner.nextLine());
        while (flag) {
            System.out.println("chọn thông tin cần sửa\n" +
                    "1. Name\n" +
                    "2.Price\n"+
                    "3. Thoát");
            int choose1 = Integer.parseInt(scanner.nextLine());
            switch (choose1) {
                case 1:
                    System.out.println("Nhập tên cần sửa");
                    String name = scanner.nextLine();
                    list.get(choose - 1).setName(name);
                    break;
                case 2:
                    System.out.println("Nhập giá cần sửa");
                    float price = Float.parseFloat(scanner.nextLine());
                    list.get(choose - 1).setPrice(price);
                    break;
                case 3:
                    flag =false;
                    break;
                default:
                    System.out.println("Bạn đã chọn sai. Chọn lại");
                    break;
            }

        }
        FuncWriteAndRead.writeProduct(list,false);
    }
    public void deleteProduct(){
        List<Product> list = FuncWriteAndRead.readProduct();
        showProductList();
        System.out.println("Chọn sản phẩm muốn xóa");
        int choose = Integer.parseInt(scanner.nextLine());
        list.remove(choose-1);
        FuncWriteAndRead.writeProduct(list,false);
    }
    public void searchByName(){
        List<Product> list = FuncWriteAndRead.readProduct();
        System.out.println("nhập tên sp cần tìm");
        String nameSearch = scanner.nextLine();
        for ( Product product: list) {
            if (product.getName().contains(nameSearch)){
                System.out.println(product);
            }
        }
    }
}
