package ngay_11_collection_framework.bai_tap.production_linkedlist;

import java.util.Comparator;

public class ProductLinked implements Comparator<ProductLinked> {
    private int id;
    private String name;
    private double price;

    public ProductLinked() {
    }

    public ProductLinked(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compare(ProductLinked o1, ProductLinked o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
