package Models;

public abstract class Services {
    public String id;
    public String nameService;
    public float area;
    public float price;
    public int maxPeople;
    public String typeRental;

    public Services(String id, String nameService, float area, float price, int maxPeople, String typeRental) {
        this.id = id;
        this.nameService = nameService;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.typeRental = typeRental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    abstract String showInformation();
}
