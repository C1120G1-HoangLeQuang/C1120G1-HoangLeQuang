package Model;

public class Motorbike extends Transportation {
    private int horsePower;

    public Motorbike() {
    }

    public Motorbike(String licensePlate, String brand, String yearMFG, String owner, int horsePower) {
        super(licensePlate, brand, yearMFG, owner);
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String showInformation() {
        return "Motorbike {" + "License plate: " + getLicensePlate() + ", "
                + "Brand: " + getBrand() + ", "
                + "Year of MFG: " + getYearMFG() + ", "
                + "Owner: " + getOwner() + ", "
                + "Arbitration: " + getHorsePower() + "}";
    }

    @Override
    public String toString() {
        return  licensePlate + "," +
                brand + "," +
                yearMFG + "," +
                owner + "," +
                horsePower;
    }
}
