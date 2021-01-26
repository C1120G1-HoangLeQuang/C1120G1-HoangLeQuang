package session_16_byteStream_Serialization.bai_tap.bai_2_Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static List<Product> productList = new ArrayList<>();
    private static final String PATH = "src/session_16_byteStream_Serialization/bai_tap/bai_2_Product/DataProduct.";

    public static void main(String[] args) throws Exception{
        addProduct("Iphone", "Apple", "1900", "12Pro");
        addProduct("GalaxyNote", "SamSung", "1500", "Note7");
        showProduct();
    }
    private static void writeProduct() throws Exception{
        File file = new File(PATH);
        FileOutputStream fileOutput = new FileOutputStream(file);
        try {
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            for (Product product : productList) {
                output.writeObject(product.toString());
            }
            output.flush();
            output.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void readProduct() throws Exception{
        File file = new File(PATH);
        FileInputStream fileInput = new FileInputStream(file);
        try {
            ObjectInputStream input = new ObjectInputStream(fileInput);
            Product product;
            while ((product = (Product) input.readObject()) != null) {
                productList.add(product);
            }
            input.close();
        } catch (EOFException e) {
            System.out.println("Load success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void addProduct(String name, String brand, String price, String otherDescription) throws Exception {
        readProduct();
        productList.add(new Product(name, brand, price, otherDescription));
        writeProduct();
    }
    private static void showProduct() throws Exception {
        readProduct();
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }
}
