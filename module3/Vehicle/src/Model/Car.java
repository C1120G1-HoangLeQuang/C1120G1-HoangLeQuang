package Model;

public class Car extends Transportation {
    private int numberSeat;
    private String typeCar;

    public Car() {
    }

    public Car(String licensePlate, String brand, String yearMFG, String owner, int numberSeat, String typeCar) {
        super(licensePlate, brand, yearMFG, owner);
        this.numberSeat = numberSeat;
        this.typeCar = typeCar;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String showInformation() {
        return "Car {" + "License plate: " + getLicensePlate() + ", "
                    + "Brand: " + getBrand() + ", "
                    + "Year of MFG: " + getYearMFG() + ", "
                    + "Owner: " + getOwner() + ", "
                    + "Number of Seat: " + getNumberSeat() + ", "
                    + "Type of car: " + getTypeCar() + "}";
    }

    @Override
    public String toString() {
        return  licensePlate + "," +
                brand + "," +
                yearMFG + "," +
                owner + "," +
                numberSeat + "," +
                typeCar;
    }
}
