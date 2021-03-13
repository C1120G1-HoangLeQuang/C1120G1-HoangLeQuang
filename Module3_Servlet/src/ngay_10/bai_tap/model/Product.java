package ngay_10.bai_tap.model;

public class Product {
    private int id;
    private String name;
    private String nationality;
    private String type;
    private int price;

    public Product() {
    }

    public Product(int id, String name, String nationality, String type, int price) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.type = type;
        this.price = price;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
