package Models;

import java.util.Objects;

public class Villa extends Services {
    private String roomStandard;
    private String otherService;
    private float poolArea;
    private int numberFloor;

    public Villa(String id, String nameService, float area, float price, int maxPeople, String typeRental) {
        super(id, nameService, area, price, maxPeople, typeRental);
    }

    public Villa(String id, String nameService, float area, float price, int maxPeople, String typeRental, String roomStandard, String otherService, float poolArea, int numberFloor) {
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String showInformation() {
        return "Villa {" + "IdService: " + getId() + ", "
            + "NameService: " + getNameService() + ", "
            + "Area: " + getArea() + ", "
            + "Price: " + getPrice() + ", "
            + "MaxPeople: " + getMaxPeople() + ", "
            + "RentalType: " + getTypeRental() + ", "
            + "RoomStandard: " + getRoomStandard() + ", "
            + "OtherService: " + getOtherService() + ", "
            + "PoolArea: " + getPoolArea() + ", "
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
                poolArea + ',' +
                numberFloor;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if ((obj == null) ||(getClass() != obj.getClass())) {
//            return false;
//        }
//        Villa villa = (Villa) obj;
//        return nameService == villa.nameService;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(nameService);
//    }
}
