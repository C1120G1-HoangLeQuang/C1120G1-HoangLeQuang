package Models;

public class House extends Services {
    private String roomStandard;
    private String otherService;
    private String numberFloor;

    public House(String id, String nameService, float area, float price, String maxPeople, String typeRental) {
        super(id, nameService, area, price, maxPeople, typeRental);
    }

    public House(String id, String nameService, float area, float price, String maxPeople, String typeRental, String roomStandard, String otherService, String numberFloor) {
        super(id, nameService, area, price, maxPeople, typeRental);
        this.roomStandard = roomStandard;
        this.otherService = otherService;
        this.numberFloor = numberFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherService() {
        return otherService;
    }

    public void setOtherService(String otherService) {
        this.otherService = otherService;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    void showInformation() {
        System.out.println("Villa {" + "IdService: " + getId() + "\n"
                + "NameService: " + getNameService() + "\n"
                + "Area: " + getArea() + "\n"
                + "Price: " + getPrice() + "\n"
                + "MaxPeople: " + getMaxPeople() + "\n"
                + "RentalType: " + getTypeRental() + "\n"
                + "RoomStandard: " + getRoomStandard() + "\n"
                + "OtherService: " + getOtherService() + "\n"
                + "NumberFloor: " + getNumberFloor() + "}");
    }

    @Override
    public String toString() {
        return  id + ',' +
                nameService + ',' +
                area + ',' +
                price + ',' +
                maxPeople + ',' +
                typeRental + ',' +
                roomStandard + ',' +
                otherService + ',' +
                numberFloor;
    }
}
