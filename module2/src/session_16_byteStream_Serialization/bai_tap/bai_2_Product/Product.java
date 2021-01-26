package session_16_byteStream_Serialization.bai_tap.bai_2_Product;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Product implements Serializable {
    private static final AtomicInteger atomicInteger = new AtomicInteger(0);
    private int id;
    private String name;
    private String brand;
    private String price;
    private String OtherDescription;

    public Product() {
    }

    public Product(String name, String brand, String price, String otherDescription) {
        this.id = atomicInteger.incrementAndGet();
        this.name = name;
        this.brand = brand;
        this.price = price;
        OtherDescription = otherDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOtherDescription() {
        return OtherDescription;
    }

    public void setOtherDescription(String OtherDescription) {
        this.OtherDescription = OtherDescription;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id: " + id
                + ", name: " + name
                + ", brand: " + brand
                + ", price: " + price
                + ", otherDescription: " + OtherDescription
                + '}';
    }
}
