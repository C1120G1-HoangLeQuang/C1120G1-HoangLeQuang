package Models;

public class Room extends Services{
    private String freeService;

    public Room(String id, String nameService, float area, float price, int maxPeople, String typeRental) {
        super(id, nameService, area, price, maxPeople, typeRental);
    }

    public Room(String id, String nameService, float area, float price, int maxPeople, String typeRental, String freeService) {
        super(id, nameService, area, price, maxPeople, typeRental);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String showInformation() {
        return "Room {" + "IdService: " + getId() + ", "
                + "NameService: " + getNameService() + ", "
                + "Area: " + getArea() + ", "
                + "Price: " + getPrice() + ", "
                + "MaxPeople: " + getMaxPeople() + ", "
                + "RentalType: " + getTypeRental() + ", "
                + "FreeService: " + getFreeService() + "}";
    }

    @Override
    public String toString() {
        return  id + ',' +
                nameService + ',' +
                area + ',' +
                price + ',' +
                maxPeople + ',' +
                typeRental + ',' +
                freeService;
    }
}
