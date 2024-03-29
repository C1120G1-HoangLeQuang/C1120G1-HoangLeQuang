package Models;

public class House extends Services {
    private String roomStandard;
    private String otherService;
    private int numberFloor;

    public House(String id, String nameService, float area, float price, int maxPeople, String typeRental) {
        super(id, nameService, area, price, maxPeople, typeRental);
    }

    public House(String id, String nameService, float area, float price, int maxPeople, String typeRental, String roomStandard, String otherService, int numberFloor) {
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String showInformation() {
        return "House {" + "IdService: " + getId() + ", "
                + "NameService: " + getNameService() + ", "
                + "Area: " + getArea() + ", "
                + "Price: " + getPrice() + ", "
                + "MaxPeople: " + getMaxPeople() + ", "
                + "RentalType: " + getTypeRental() + ", "
                + "RoomStandard: " + getRoomStandard() + ", "
                + "OtherService: " + getOtherService() + ", "
                + "NumberFloor: " + getNumberFloor() + "}";
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
