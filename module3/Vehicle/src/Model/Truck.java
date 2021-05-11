package Model;

public class Truck extends Transportation {
    private int arbitration; // trong tai?

    public Truck() {
    }

    public Truck(String licensePlate, String brand, String yearMFG, String owner, int arbitration) {
        super(licensePlate, brand, yearMFG, owner);
        this.arbitration = arbitration;
    }

    public int getArbitration() {
        return arbitration;
    }

    public void setArbitration(int arbitration) {
        this.arbitration = arbitration;
    }

    @Override
    public String showInformation() {
        return "Truck {" + "License plate: " + getLicensePlate() + ", "
                + "Brand: " + getBrand() + ", "
                + "Year of MFG: " + getYearMFG() + ", "
                + "Owner: " + getOwner() + ", "
                + "Arbitration: " + getArbitration() + "}";
    }

    @Override
    public String toString() {
        return  licensePlate + "," +
                brand + "," +
                yearMFG + "," +
                owner + "," +
                arbitration;
    }
}
