package Models;

public class Villa extends Services {
    private String roomStandard;
    private String otherService;
    private float poolArea;
    private String numberFloor;

    public Villa(String id, String nameService, float area, float price, String maxPeople, String typeRental) {
        super(id, nameService, area, price, maxPeople, typeRental);
    }

    public Villa(String id, String nameService, float area, float price, String maxPeople, String typeRental, String roomStandard, String otherService, float poolArea, String numberFloor) {
        super(id, nameService, area, price, maxPeople, typeRental);
        this.roomStandard = roomStandard;
        this.otherService = otherService;
        this.poolArea = poolArea;
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

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public void showInformation() {
        System.out.println("Villa {" + "IdService: " + getId() + "\n"
            + "NameService: " + getNameService() + "\n"
            + "Area: " + getArea() + "\n"
            + "Price: " + getPrice() + "\n"
            + "MaxPeople: " + getMaxPeople() + "\n"
            + "RentalType: " + getTypeRental() + "\n"
            + "RoomStandard: " + getRoomStandard() + "\n"
            + "OtherService: " + getOtherService() + "\n"
            + "PoolArea: " + getPoolArea() + "\n"
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
                poolArea + ',' +
                numberFloor;
    }
}
